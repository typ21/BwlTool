package de.adesso.jani.Netzplan;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import de.adesso.jani.Netzplan.manager.NodeManager;
import de.adesso.jani.Netzplan.model.Node;
import de.adesso.jani.views.sites.NetplanView;

import java.util.ArrayList;
import java.util.List;

public class NetzPlanConnector {

    private final NetplanView net;

    private final List<Node> nodes;
    private final NodeManager manager;

    public NetzPlanConnector(NetplanView npv, String[] names, int[] durations, String[] predecessor) throws Exception {

        this.net = npv;

        manager = new NodeManager(this);

        //TestDataFactory testDataFactory = new TestDataFactory();

        nodes = new ArrayList<>();

        for(int i = 0; i < names.length; i++) {



            String[] preNoteIDs = predecessor[i].split(",");

            ArrayList<Node> prevNodes = new ArrayList<>();
            if(!predecessor[i].isEmpty() && predecessor[i] != null && !predecessor[i].isBlank())
                for (String preNoteID : preNoteIDs) {
                    try {

                        int currentID = Integer.parseInt(preNoteID);
                        prevNodes.add(nodes.get(currentID - 1));

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Notification.show("Vorgang " + i + ": Konnte einen Vorgängerprozess nicht zuordnen, " +
                                "bitte gebe jeweils NUR die VorgangsID an und nichts weiteres. :)");
                        throw new Exception("Unable to parse!");
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                        Notification.show("Vorgang " + i + ": Ein Vorgang, den du als Vorgänger angegeben hast"
                                + " wird entweder gar nicht, oder erst später definiert. Vorgänger können nur schon"
                                + " definierte Vorgänge sein!");
                        throw new Exception("Unable to parse!");
                    }

                }

            System.out.println(i+1 + " , " + names[i] + " , " + durations[i] + " , " + prevNodes.toString() );

            Node n = new Node(i+1, names[i], durations[i], prevNodes, this);
            nodes.add(n);
        }

    }

    public void calcAndPrint(){
        manager.runNetzplan(nodes);

        for(Node n : nodes) {
            if(!n.getName().equals("HELP_NODE"))
                n.drawNode();
        }
    }

    public void println(){
        Span holder = new Span();
        net.addSpan(holder);
    }

    public void println(String s){
        Span holder = new Span(s);
        net.addSpan(holder);
    }

    public void printf(String format, Object... args){
        String formatted = String.format(format, args);
        Span holder = new Span(formatted);
        net.addSpan(holder);
    }
}
