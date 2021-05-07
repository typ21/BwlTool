package de.adesso.jani.views.sites.Calculations;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.NetplanFrontendUtil.Node;
import de.adesso.jani.Netzplan.NetzPlanConnector;
import de.adesso.jani.views.main.MainView;

import java.util.ArrayList;

@PageTitle("Netplanrechner")
@Route(value="netzplan", layout= MainView.class)
public class NetplanView extends VerticalLayout {

    HorizontalLayout hlAdd;
    HorizontalLayout hlPrevs;
    VerticalLayout vlNodes;
    VerticalLayout output;

    TextField name;
    BigDecimalField duration;
    ArrayList<BigDecimalField> previous;

    ArrayList<Node> nodes;

    Button addPrev;
    Button addPoint;
    Button calc;
    Button clear;

    public NetplanView(){
        objects();
        listener();
        settings();
        build();
    }

    private void build() {
        hlAdd.add(name, duration,clear, addPoint);
        hlPrevs.add(addPrev);
        add(hlAdd, hlPrevs, calc,  vlNodes, output);
    }

    private void settings() {
        this.setAlignItems(Alignment.CENTER);
        this.setWidthFull();
        hlAdd.setWidthFull();
        hlAdd.setAlignItems(Alignment.END);
        hlPrevs.setWidthFull();
        hlPrevs.setAlignItems(Alignment.END);
        vlNodes.setWidthFull();
        vlNodes.getStyle().set("border", "1px solid #818996");
        calc.setWidthFull();
        calc.setText("Berechnen");
        calc.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addPoint.setText("Knotenpunkt hinzufügen");
        addPoint.setWidth("33%");
        addPoint.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addPrev.setText("Vorherigen hinzufügen");
        addPrev.setWidthFull();
        addPrev.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        name.setWidth("33%");
        duration.setWidth("33%");


        name.setLabel("Name");
        name.setSuffixComponent(new Span("Abc"));
        duration.setLabel("Dauer");
        duration.setSuffixComponent(new Span("#"));

        calc.setWidthFull();
        calc.setText("Berechnen");
        calc.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        output.setWidthFull();
        output.getStyle().set("border", "1px solid #818996");

        clear.setText("C");
    }

    private void listener() {
        clear.addClickListener(e -> {
           name.clear();
           duration.clear();
        });
        addPrev.addClickListener(e -> {
            BigDecimalField field = new BigDecimalField();
            field.setWidthFull();
            field.setLabel("Vorgänger");
            field.setSuffixComponent(new Span("#"));
            previous.add(field);
            hlPrevs.remove(addPrev);
            hlPrevs.add(field, addPrev);
        });
        addPoint.addClickListener(e ->{
            StringBuilder prevs = new StringBuilder(" ");
            for(BigDecimalField prev: previous){
                if(prev.getValue() != null)
                    prevs.append(prev.getValue().toString()).append(",");
            }
            if(prevs.charAt(prevs.length()-1) == ','){
                prevs = new StringBuilder(prevs.substring(0, prevs.length() - 1).replace(" ", ""));
            }
            Node node = new Node(name.getValue(), "#" + (nodes.size() + 1),duration.getValue().doubleValue(), prevs.toString(), this);
            hlPrevs.removeAll();
            hlPrevs.add(addPrev);
            previous = new ArrayList<>();
            nodes.add(node);
            vlNodes.add(node);
        });
        calc.addClickListener(e -> {
            output.removeAll();
            String[] name = new String[nodes.size()];
            int[] dur = new int[nodes.size()];
            String[] prev = new String[nodes.size()];

            for(int i = 0; i < nodes.size(); i++){
                dur[i] = nodes.get(i).getDuration();
                name[i] = nodes.get(i).getName();
                prev[i] = nodes.get(i).getPrevs();
            }

            try {
                NetzPlanConnector npc = new NetzPlanConnector(this, name, dur, prev);
                npc.calcAndPrint();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
    }

    private void objects() {
        hlAdd = new HorizontalLayout();
        name = new TextField();
        duration = new BigDecimalField();
        previous = new ArrayList<>();
        addPrev = new Button();
        addPoint = new Button();
        nodes = new ArrayList<>();
        hlPrevs = new HorizontalLayout();
        vlNodes = new VerticalLayout();
        calc = new Button();
        output = new VerticalLayout();
        clear = new Button();
    }

    public void removeNode(Node node) {
        int pos = nodes.indexOf(node);
        vlNodes.removeAll();
        for(Node n: nodes){
            if(nodes.indexOf(n) > pos){
                n.setID("#" + nodes.indexOf(n));
            }
            vlNodes.add(n);
        }
        this.nodes.remove(node);
        this.vlNodes.remove(node);
    }

    public void addSpan(Span text){
        text.setWidthFull();
        output.add(text);
    }
}
