package de.adesso.jani.views.sites;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.BAB.Kostenart;
import de.adesso.jani.views.main.MainView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

@Route(value="bab", layout= MainView.class)
@PageTitle("Betriebsabrechnungsbogen")
public class BABView extends VerticalLayout {

    BigDecimalField[] einzelkosten;

    HorizontalLayout addKA;
    BigDecimalField gesKostBuch;
    BigDecimalField[] schluessel;
    Button addKAButton;

    ArrayList<Kostenart> kostenarten;

    BigDecimalField lagermehrbestaende;
    BigDecimalField lagerminderbestaende;

    VerticalLayout gemeinkosten;

    Button calculate;
    Button clear;

    //AfterCalculation

    Span herstellkostenUmsatz;
    Span selbstkostenProduktion;
    Span herstellkostenErzeugung;
    HorizontalLayout hlSum;
    Span[] sums;
    VerticalLayout hlSets;
    Span[] sets;


    public BABView(){
        objects();
        settings();
        listener();
        build();
    }

    private void listener() {
        clear.addClickListener(e -> {
            for(int i = 0; i < schluessel.length; i++){
                schluessel[i].clear();
            }
            gesKostBuch.clear();
        });
        addKAButton.addClickListener(e -> {
            Kostenart ka = new Kostenart(gesKostBuch.getValue().doubleValue(), new Double[]{
                    schluessel[0].getValue().doubleValue(),
                    schluessel[1].getValue().doubleValue(),
                    schluessel[2].getValue().doubleValue(),
                    schluessel[3].getValue().doubleValue()},
                    this);
            kostenarten.add(ka);
            gemeinkosten.add(ka);
        });
        calculate.addClickListener(e -> {

            Double[] intsums = new Double[5];

            Arrays.fill(intsums, 0d);

            for(Kostenart ka: kostenarten){
                intsums[0] += ka.getGesamtkosten();
                intsums[1] += ka.getMaterialgemainkosten();
                intsums[2] += ka.getFertigungsGemeinkosten();
                intsums[3] += ka.getVerwaltungsgemeinkosten();
                intsums[4] += ka.getVertriebsgemeinkosen();
            }
            for(int i = 0; i < 5; i++) {
                sums[i].setText(String.valueOf(intsums[i]));
                sums[i].setWidth("12%");
            }
            hlSum.removeAll();
            Div div = new Div();
            div.setWidth("7px");
            div.setHeight("1px");
            hlSum.add(div);
            hlSum.add(sums);

            double herstellkE = intsums[1] + einzelkosten[0].getValue().doubleValue() + intsums[2] + einzelkosten[1].getValue().doubleValue();
            herstellkostenErzeugung.setText("Herstellkosten der Erzeugung: "+ herstellkE);

            Double herstellkU = herstellkE + lagerminderbestaende.getValue().doubleValue() - lagermehrbestaende.getValue().doubleValue();
            herstellkostenUmsatz.setText("Herstellekosten des Umsatzes: " + herstellkU);

            selbstkostenProduktion.setText("Selbstkosten der Produktion: " + (intsums[0] + einzelkosten[0].getValue().doubleValue() +
                    einzelkosten[1].getValue().doubleValue() + einzelkosten[2].getValue().doubleValue() +
                    einzelkosten[3].getValue().doubleValue()));

            sets[0].setText("Materialgemeinkostenzuschlagssatz: " + (intsums[1] / einzelkosten[0].getValue().doubleValue()) * 100);
            sets[1].setText("Fertigungskostenzuschlagssatz: " + (intsums[2] / einzelkosten[1].getValue().doubleValue()) * 100);
            sets[2].setText("Verwaltungsgemeinkostenzuschlagssatz: " + (intsums[3] / herstellkU) * 100);
            sets[3].setText("Vertriebsgemeinkostenzuschlagssatz: " + (intsums[4] / herstellkU) * 100);

            hlSets.removeAll();
            hlSets.add(sets);

        });
    }

    private void build() {
        HorizontalLayout lager = new HorizontalLayout();
        lager.setWidthFull();
        lager.add(lagermehrbestaende, lagerminderbestaende);
        add(lager);

        HorizontalLayout hlEinzelkosten = new HorizontalLayout();
        hlEinzelkosten.setWidthFull();
        hlEinzelkosten.add(einzelkosten);
        add(hlEinzelkosten);

        addKA.add(gesKostBuch);
        addKA.add(schluessel);
        addKA.add(clear, addKAButton);
        add(addKA, calculate);
        add(gemeinkosten, hlSum, hlSets, herstellkostenErzeugung,  herstellkostenUmsatz, selbstkostenProduktion);
    }

    private void settings() {
        gesKostBuch.setLabel("Gesamtkosten Buchhaltung");
        gesKostBuch.setClearButtonVisible(true);
        gesKostBuch.setSuffixComponent(new Span("€"));
        gesKostBuch.setWidth("20%");

        for(int i = 0; i < schluessel.length; i++){
            schluessel[i].setLabel("Schlüssel: " + i);
            schluessel[i].setWidth("13%");
            schluessel[i].setClearButtonVisible(true);
        }
        addKAButton.setText("Kostenart Hinzufügen");

        einzelkosten[0].setLabel("Materialeinzelkosten");
        einzelkosten[1].setLabel("Fertigungeinzelkosten");
        einzelkosten[2].setLabel("Verwaltungseinzelkosten");
        einzelkosten[2].setValue(BigDecimal.valueOf(0d));
        einzelkosten[3].setLabel("Vertriebseinzelkosten");
        einzelkosten[3].setValue(BigDecimal.valueOf(0d));

        for (BigDecimalField bigDecimalField : einzelkosten) {
            bigDecimalField.setSuffixComponent(new Span("€"));
            bigDecimalField.setWidth("25%");
        }

        lagerminderbestaende.setWidth("50%");
        lagerminderbestaende.setLabel("Lagerminderbestände");
        lagerminderbestaende.setSuffixComponent(new Span("€"));

        lagermehrbestaende.setWidth("50%");
        lagermehrbestaende.setLabel("Lagermehrbeschände");
        lagermehrbestaende.setSuffixComponent(new Span("€"));

        gemeinkosten.getStyle().set("border", "1px solid #818996");

        addKA.setAlignItems(Alignment.END);
        addKA.setWidthFull();
        addKAButton.setWidth("20%");
        addKAButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        calculate.setWidthFull();
        calculate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        calculate.setText("Berechnen");

        hlSum.getStyle().set("border", "1px solid #818996");
        hlSum.setWidthFull();

        hlSets.getStyle().set("border", "1px solid #818996");
        hlSets.setWidthFull();

        for(int i = 0; i < 4; i++)
            sets[i].setWidth("20%");
        clear.setText("C");
    }

    private void objects() {
        addKA = new HorizontalLayout();
        gesKostBuch = new BigDecimalField();
        schluessel = new BigDecimalField[4];
        for(int i = 0; i < schluessel.length; i++)
            schluessel[i] = new BigDecimalField();
        addKAButton = new Button();

        einzelkosten = new BigDecimalField[4];
        for(int i = 0; i < einzelkosten.length; i++)
            einzelkosten[i] = new BigDecimalField();

        lagermehrbestaende = new BigDecimalField();
        lagerminderbestaende = new BigDecimalField();

        gemeinkosten = new VerticalLayout();
        kostenarten = new ArrayList<>();

        calculate = new Button();

        selbstkostenProduktion = new Span();
        herstellkostenUmsatz = new Span();
        herstellkostenErzeugung = new Span();
        sets = new Span[4];
        for(int i = 0; i < 4; i++)
            sets[i] = new Span();
        sums = new Span[5];
        for(int i = 0; i < 5; i++)
            sums[i] = new Span();
        hlSets = new VerticalLayout();
        hlSum = new HorizontalLayout();
        clear = new Button();
    }

    public void removeKA(Kostenart ka){
        gemeinkosten.remove(ka);
        kostenarten.remove(ka);
    }
}
