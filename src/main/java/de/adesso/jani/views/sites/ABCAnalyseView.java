package de.adesso.jani.views.sites;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.ABCAnal.ABCAnalyse;
import de.adesso.jani.ABCAnal.ABCElement;
import de.adesso.jani.views.main.MainView;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

import java.util.ArrayList;
import java.util.List;

@Route(value="abcanalyse", layout= MainView.class)
@PageTitle("ABC-Analye")
public class ABCAnalyseView extends VerticalLayout {

    ArrayList<ABCElement> elements;

    VerticalLayout vlSolution;
    HorizontalLayout groups;
    VerticalLayout vlElements;
    HorizontalLayout hlAddElement;

    TextField nameField;
    BigDecimalField bdField;
    BigDecimalField optionalBDField;

    Button addElement;
    Button calculate;
    Button clear;

    BigDecimalField[] groupFields;

    public ABCAnalyseView(){
        objects();
        settings();
        listener();
        build();
    }

    private void build() {
        groups.add(groupFields);
        hlAddElement.add(nameField, bdField, optionalBDField, clear, addElement);
        add(hlAddElement, groups, calculate, vlElements, vlSolution);
    }

    private void listener() {
        addElement.addClickListener(e -> {
            double optional = 1d;
            if(optionalBDField.getValue() != null){
                optional = optionalBDField.getValue().doubleValue();
            }
           addElement(nameField.getValue(), bdField.getValue().doubleValue(), optional);
        });
        calculate.addClickListener(e -> this.calculate());
        clear.addClickListener(e -> {
           nameField.clear();
           bdField.clear();
           optionalBDField.clear();
        });
    }

    private void calculate() {
        ABCAnalyse analys = new ABCAnalyse(elements);
        List<ABCElement> elements = analys.analyze(groupFields[0].getValue().doubleValue() / 100, groupFields[1].getValue().doubleValue() / 100,
                groupFields[2].getValue().doubleValue() / 100);
        vlSolution.removeAll();
        Double gesamtUmsatz = 0d;
        for(ABCElement element:elements){
            vlSolution.add(element.filled());
            gesamtUmsatz += element.getUmsatz();
        }
        vlSolution.add(new Span("Die Gesamtmenge an Umsatz beträgt: " + gesamtUmsatz));
        vlSolution.add(new Span("Wie viel % des Umsatzes befindet sich in Gruppe A?: " + analys.getASum()));
        vlSolution.add(new Span("Wie viel % des Umsatzes befindet sich in Gruppe B?: " + analys.getBSum()));
        vlSolution.add(new Span("Wie viel % des Umsatzes befindet sich in Gruppe C?: " + analys.getCSum()));

    }

    private void settings() {
        this.setAlignItems(Alignment.CENTER);
        calculate.setText("berechnen");
        hlAddElement.setWidthFull();
        hlAddElement.setAlignItems(Alignment.END);
        addElement.setText("hinzufügen");
        addElement.setWidth("50%");
        addElement.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        nameField.setWidth("20%");
        bdField.setWidth("20%");
        calculate.setWidth("50%");
        nameField.setLabel("Kunde/Produkt");
        bdField.setLabel("Umsatz");
        bdField.setSuffixComponent(new Span("€"));
        optionalBDField.setLabel("Menge/Anzahl (Optional)");
        optionalBDField.setWidth("20%");
        vlSolution.setWidthFull();
        vlElements.getStyle().set("border", "1px solid #818996");
        vlSolution.getStyle().set("border", "1px solid #818996");
        vlElements.setWidthFull();
        calculate.setWidthFull();
        calculate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        groups.setWidthFull();
        for(int i = 0; i < 3; i++){
            groupFields[i].setWidth("33%");
            groupFields[i].setSuffixComponent(new Span("%"));
        }
        groupFields[0].setLabel("Anteil Gruppe A");
        groupFields[1].setLabel("Anteil Gruppe B");
        groupFields[2].setLabel("Anteil Gruppe C");
        vlElements.setAlignItems(Alignment.CENTER);
        vlSolution.setAlignItems(Alignment.CENTER);
        clear.setText("C");
    }

    private void objects() {
        elements = new ArrayList<>();
        vlElements = new VerticalLayout();
        vlSolution = new VerticalLayout();
        hlAddElement = new HorizontalLayout();
        addElement = new Button();
        nameField = new TextField();
        bdField = new BigDecimalField();
        calculate = new Button();
        groups = new HorizontalLayout();
        groupFields = new BigDecimalField[3];
        optionalBDField = new BigDecimalField();
        for(int i = 0; i < 3; i++)
            groupFields[i] = new BigDecimalField();
        clear = new Button();
    }

    private void addElement(String name, Double umsatz, Double optional){
        ABCElement element = new ABCElement(name, umsatz * optional, this);
        elements.add(element);
        vlElements.add(element);
    }

    public void removeElement(ABCElement abcElement) {
        elements.remove(abcElement);
        vlElements.remove(abcElement);
    }
}
