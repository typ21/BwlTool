package de.adesso.jani.BAB;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import de.adesso.jani.views.sites.BABView;

public class Kostenart extends HorizontalLayout {
    Double gesamtkosten;

    Double[] werte;

    BABView father;

    Button remove = new Button("entfernen");
    public Kostenart(Double gesamtkosten, Double[] schluessel, BABView father){
        objects();
        this.gesamtkosten = gesamtkosten;
        Double aSch = schluessel[0] + schluessel[1] + schluessel[2] + schluessel[3];
        Double sch1 = gesamtkosten / aSch;
        for(int i = 0; i<schluessel.length; i++){
            werte[i] = sch1 * schluessel[i];
        }
        this.father = father;
        settings();
        listener();
        build();
    }

    private void settings() {
        this.setWidthFull();
        remove.setWidth("20%");
    }

    private void listener() {
        remove.addClickListener(e -> father.removeKA(this));
    }

    private void build() {
        this.removeAll();
        Span[] spans = new Span[5];
        for(int i = 0; i < spans.length; i++) {
            spans[i] = new Span();
            spans[i].setWidth("20%");
        }
        spans[0].setText(String.valueOf(gesamtkosten));
        for (Span span : spans) span.setWidth("12%");
        for (int i = 1; i < spans.length; i++)
            spans[i].setText(String.valueOf(werte[i - 1]));
        add(spans);
        add(remove);
    }
    private void objects() {
        werte = new Double[4];
    }

    public Double getGesamtkosten() {
        return gesamtkosten;
    }

    public Double getMaterialgemainkosten(){
        return werte[0];
    }

    public Double getFertigungsGemeinkosten(){
        return werte[1];
    }

    public Double getVerwaltungsgemeinkosten(){
        return werte[2];
    }

    public Double getVertriebsgemeinkosen(){
        return werte[3];
    }
}
