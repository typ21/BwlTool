package de.adesso.jani.views.OwnComponents.ABCAnal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import de.adesso.jani.views.sites.Calculations.ABCAnalyseView;

public class ABCElement extends HorizontalLayout {

    private String name;
    private final Double umsatz;
    private char group;
    private Double percentage;
    private Double percentageCum;

    Button remove;

    ABCAnalyseView father;

    public ABCElement(String name, Double umsatz, ABCAnalyseView father){
        this.name = name;
        this.umsatz = umsatz;
        this.father = father;
        this.init();
    }

    private void init() {
        objects();
        settings();
        listener();
        build();
    }

    private void objects() {
        remove = new Button();
    }

    private void build() {
        Span sname = new Span(name);
        sname.setWidth("33%");
        Span sumsatz = new Span(String.valueOf(umsatz));
        sumsatz.setWidth("33%");
        remove.setWidth("33%");
        add(sname, sumsatz, remove);
    }

    private void listener() {
        remove.addClickListener(e -> father.removeElement(this));
    }

    public HorizontalLayout filled(){
        HorizontalLayout filled = new HorizontalLayout();
        filled.setAlignItems(Alignment.CENTER);
        filled.setWidthFull();
        Span sname = new Span(name);
        sname.setWidth("20%");
        Span sumsatz = new Span(String.valueOf(umsatz));
        sumsatz.setWidth("20%");
        Span sperc = new Span(String.valueOf(percentage));
        sperc.setWidth("20%");
        Span spersc = new Span(String.valueOf(percentageCum));
        spersc.setWidth("20%");
        Span sgroup =  new Span(String.valueOf(group));
        sgroup.setWidth("20%");
        filled.add(sname, sumsatz, sperc , spersc, sgroup)
               ;
        return filled;
    }

    private void settings() {
        this.setAlignItems(Alignment.CENTER);
        remove.setText("entfernen");
        this.setWidthFull();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUmsatz() {
        return umsatz;
    }


    public void setGroup(char group) {
        this.group = group;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }


    public void setPercentageCum(Double percentageCum) {
        this.percentageCum = percentageCum;
    }
}
