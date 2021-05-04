package de.adesso.jani.Netzplan.manager;

import de.adesso.jani.Netzplan.NetzPlanConnector;
import de.adesso.jani.Netzplan.model.Node;

import java.util.*;

public class NodeManager implements NodeManagerLocal {

    public static final String HELP_NODE = "HELP_NODE";

    private final NetzPlanConnector connect;

    public NodeManager(NetzPlanConnector np) {
        this.connect = np;
    }

    /**
     * calculate a netzplan
     * the sequence must not be changed,
     * @param nodes Nodes to run on
     */
    @Override
    public void runNetzplan(List<Node> nodes) {
        getNextNodesFor(nodes);
        createHelpNode(nodes);
        calcFazAndFez(nodes);
        calcSazAndSez(nodes);
        calcGpAndFp(nodes);

        List<Node> criticalPathNodes = getCriticalPath(nodes);
        printCriticalPath(criticalPathNodes);
    }

    /**
     * forward calculation
     * faz= node ? firstNode ? 0 : node(i).duration + node(i-1).fez (largest)
     * fez=
     * @param nodes Nodes to run on
     */
    protected void calcFazAndFez(List<Node> nodes) {
        if (nodes != null && !nodes.isEmpty()) {
            Node n1 = nodes.get(0);

            for (Node node : nodes) {
                if (node.getPrevNodes().isEmpty()) {
                    node.setFaz(0);
                    node.setFez(node.getDuration());
                } else {
                    // related to first node
                    boolean isRelatedToFirstNode = node.getPrevNodes().stream().allMatch(n -> n.equals(n1));
                    if (isRelatedToFirstNode && !node.getPrevNodes().isEmpty()) {
                        int prevFez = node.getPrevNodes().stream().findFirst().get().getFez();
                        node.setFaz(prevFez);
                        node.setFez(node.getDuration() + node.getFaz());
                    } else {
                        // not related to first node
                        int maxFaz = -1;
                        for (Node n : node.getPrevNodes()) {
                            if (maxFaz < n.getFez()) {
                                maxFaz = n.getFez();
                            }
                        }

                        node.setFaz(maxFaz);
                        node.setFez(node.getFaz() + node.getDuration());
                    }
                }
            }
        }
    }

    /**
     * backward calculation
     * saz= sez(i) - duration
     * sez= node ? lastNode ? node(i).faz : node(i+1).faz (smallest)
     * @param nodes Nodes to run on
     */
    protected void calcSazAndSez(List<Node> nodes) {
        for (int i = nodes.size() - 1; i >= 0; i--) {
            int currentFez = nodes.get(i).getFez();
            int currentDuration = nodes.get(i).getDuration();

            // last node
            if (nodes.get(i).getNextNodes() == null || nodes.get(i).getNextNodes().isEmpty()) {
                if (nodes.get(i).getFaz() + currentDuration == currentFez) {
                    nodes.get(i).setSez(currentFez);
                } else {
                    List<Node> prevNodes = nodes.get(i).getPrevNodes();
                    List<Integer> maxFezFromNodesWithoutNextNodes = new ArrayList<>();
                    for (Node node : prevNodes) {
                        maxFezFromNodesWithoutNextNodes.add(node.getFez());
                    }

                    Integer integer = maxFezFromNodesWithoutNextNodes.stream().max(Integer::compareTo).get();
                    nodes.get(i).setSez(integer);
                }
            } else {
                int minSazFromPrevNodes = Integer.MAX_VALUE;
                for (Node n : nodes.get(i).getNextNodes()) {
                    if (minSazFromPrevNodes > n.getSaz()) {
                        minSazFromPrevNodes = n.getSaz();
                    }
                }

                nodes.get(i).setSez(minSazFromPrevNodes);
            }
            nodes.get(i).setSaz(nodes.get(i).getSez() - currentDuration);
        }
    }

    /**
     * forward calculation
     * gp= saz(i) - faz(i)
     * fp= faz(i+1) - fez(i)
     * @param nodes Nodes to run on
     */
    protected void calcGpAndFp(List<Node> nodes) {
        // calc Gp
        for (Node node : nodes) {
            int sez = node.getSez();
            int fez = node.getFez();

            node.setGp(sez - fez);
        }

        for (Node currentNode : nodes) {
            if (currentNode.getNextNodes() != null && !currentNode.getNextNodes().isEmpty()) {
                List<Node> nextNodesFrom = currentNode.getNextNodes();
                int nextFaz = nextNodesFrom.stream().map(Node::getFaz).min(Integer::compareTo).get(); // get the smallest value
                int currentFez = currentNode.getFez();
                currentNode.setFp(nextFaz - currentFez);
            }
        }

    }

    /**
     * forward calculation
     * criticalPath= node(s) = node.gp(0) & node.fp(0)
     * @param nodes Nodes to run on
     * @return list with node numbers (asc)
     */
    protected List<Node> getCriticalPath(List<Node> nodes) {
        List<Node> criticalPathNodes = new ArrayList<>();

        for (Node node : nodes) {
            boolean isHelpNode = node.getName().equals(HELP_NODE);

            if (node.getGp() == 0 && node.getFp() == 0 && !isHelpNode) {
                criticalPathNodes.add(node);
            }
        }

        return criticalPathNodes;
    }

    protected void printCriticalPath(List<Node> nodes) {
        connect.println("------------");
        connect.println("critical path");
        nodes.forEach(n -> connect.printf("%s ", n.getNumber()));
        connect.println();
        nodes.forEach(n -> connect.printf("%s ", n.getName()));
        connect.println();
    }

    /**
     * create a HELP_NODE if current node(s) does not have any next nodes and current node is not last node
     * HELP_NODE is neither displayed in the calculation nor in the console
     * @param nodes Nodes to run on
     */
    protected void createHelpNode(List<Node> nodes) {
        List<Node> prevNodes = new ArrayList<>();

        for (Node n : nodes) {
            if (n.getNextNodes() == null && n.getNumber() != nodes.size()) {
                prevNodes.add(n);
            }
        }

        if (!prevNodes.isEmpty()) {
            int counter = nodes.size() + 1;
            Node node = new Node(counter, NodeManager.HELP_NODE, 0, prevNodes, connect);
            nodes.add(node);
        }
    }


    /**
     * current node(s) searches for its direct neighbor nodes
     * @param nodes Nodes to run on
     */
    protected void getNextNodesFor(List<Node> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            List<Node> nextNodes = new ArrayList<>();
            Node currentNode = nodes.get(i);

            for (int k = 0; k < nodes.size() - 1; k++) {
                Node nextNode = nodes.get(k + 1);

                for (int j = 0; j < nextNode.getPrevNodes().size(); j++) {
                    boolean hasNeedNode = currentNode.equals(nextNode.getPrevNodes().get(j));
                    if (hasNeedNode) {
                        nextNodes.add(nextNode);
                    }
                }
            }

            if (!nextNodes.isEmpty()) {
                currentNode.setNextNodes(nextNodes);
            }
        }
    }

}
