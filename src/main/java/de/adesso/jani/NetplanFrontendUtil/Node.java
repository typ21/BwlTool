package de.adesso.jani.NetplanFrontendUtil;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import de.adesso.jani.views.sites.Calculations.NetplanView;

public class Node extends HorizontalLayout {

    String name;
    String id;
    Double duration;
    String prevs;
    NetplanView father;

    Button remove = new Button("entfernen");

    public Node(String name,String id, Double duration, String prevs, NetplanView father){
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.prevs = prevs;
        this.father = father;
        setting();
        listener();
        build();
    }

    private void setting() {
        this.setWidthFull();
    }

    private void build() {
        removeAll();
        Span[] spans = new Span[4];
        for(int i = 0; i < spans.length; i++){
            spans[i] = new Span();
            spans[i].setWidth("25%");
        }
        spans[0].setText(name);
        spans[1].setText(id);
        spans[2].setText(String.valueOf(duration));
        spans[3].setText(prevs);
        add(spans);
        add(remove);
    }

    private void listener() {
        remove.addClickListener(e -> father.removeNode(this));
    }

    public String getName(){
        return name;
    }

    public int getDuration(){
        return duration.intValue();
    }

    public String getPrevs(){
        return prevs;
    }

    public void setID(String id){
        this.id = id;
        build();
    }
}
