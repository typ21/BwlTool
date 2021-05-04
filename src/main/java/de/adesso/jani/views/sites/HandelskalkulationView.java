package de.adesso.jani.views.sites;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.main.MainView;

import java.math.BigDecimal;
import java.util.Arrays;

@Route(value="handelskalkulation", layout= MainView.class)
@PageTitle("Handelskalkulation")

public class HandelskalkulationView extends VerticalLayout {

    private HorizontalLayout[] hl;
    private VerticalLayout[] vls;
    private Text[] names;
    private BigDecimalField[] textFields;
    private Div[] placeholder;

    private Button calculate;

    de.adesso.jani.Util.Handelskalkulation calculation;

    public HandelskalkulationView() {
        createObjects();
        settings();
        listener();
        build();
    }

    private void createObjects() {
        hl = new HorizontalLayout[19];
        names = new Text[19];
        textFields = new BigDecimalField[19];
        placeholder = new Div[19];
        calculate = new Button();
        vls = new VerticalLayout[19];
        for(int i = 0; i < hl.length; i++){
            hl[i] = new HorizontalLayout();
            vls[i] = new VerticalLayout();
            names[i] = new Text("");
            textFields[i] = new BigDecimalField();
            placeholder[i] = new Div();
        }
    }

    private void build() {
        for(int i = 0; i < hl.length; i++){
            Div div = new Div();
            div.setWidth("5px");
            div.setHeight("7px");
            vls[i].add(div, names[i]);
            hl[i].add(vls[i], placeholder[i], textFields[i]);
            add(hl[i]);
        }
        add(calculate);
    }

    private void listener() {
        calculate.addClickListener(e -> calculate());
    }

    private void settings() {
        for(int i = 0; i < hl.length; i++) {
            hl[i].setWidthFull();
            vls[i].setDefaultHorizontalComponentAlignment(Alignment.END);
            vls[i].setAlignItems(Alignment.START);
            vls[i].setWidth("35%");
            placeholder[i].setHeight("50px");
            placeholder[i].setWidth("50px");
            textFields[i].setWidth("25%");
            textFields[i].setLabel("Wert");
            textFields[i].setSuffixComponent(new Span("€"));
            vls[i].setHeight(textFields[i].getHeight());
        }

        String standartPlaceholdingSpace = "50%"; //Editable

        names[0].setText("Bruttoeinkaufspreis");
        placeholder[0].setWidth(standartPlaceholdingSpace);

        names[1].setText("Nettoeinkaufspreis");
        placeholder[1].setWidth(standartPlaceholdingSpace);


        names[2].setText("Lieferantenrabatt");
        textFields[2].setLabel("Satz");
        textFields[2].setSuffixComponent(new Span("%"));

        names[3].setText("Zieleinkaufspreis");
        placeholder[3].setWidth(standartPlaceholdingSpace);

        names[4].setText("Lieferantenskonto");
        textFields[4].setLabel("Satz");
        textFields[4].setSuffixComponent(new Span("%"));

        names[5].setText("Bareinkaufspreis");
        placeholder[5].setWidth(standartPlaceholdingSpace);

        names[6].setText("Bezugskosten");
        placeholder[6].setWidth((standartPlaceholdingSpace));

        names[7].setText("Bezugspreis");
        placeholder[7].setWidth(standartPlaceholdingSpace);

        names[8].setText("Gemeinkostenzuschlag");
        textFields[8].setLabel("Satz");
        textFields[8].setSuffixComponent(new Span("%"));

        names[9].setText("Selbstkostenpreis");
        placeholder[9].setWidth(standartPlaceholdingSpace);

        names[10].setText("Gewinnaufschlag");
        textFields[10].setLabel("Satz");
        textFields[10].setSuffixComponent(new Span("%"));

        names[11].setText("Barverkaufsperis");
        placeholder[11].setWidth(standartPlaceholdingSpace);

        names[12].setText("Kundenskonto");
        textFields[12].setLabel("Satz");
        textFields[12].setSuffixComponent(new Span("%"));

        names[13].setText("Verkaufsprovision");
        textFields[13].setValue(BigDecimal.valueOf(0));
        textFields[13].setLabel("Satz");
        textFields[13].setSuffixComponent(new Span("%"));

        names[14].setText("Zielverkaufpreis");
        placeholder[14].setWidth(standartPlaceholdingSpace);

        names[15].setText("Kundenrabatt");
        textFields[15].setLabel("Satz");
        textFields[15].setSuffixComponent(new Span("%"));

        names[16].setText("Listenpreis");
        placeholder[16].setWidth(standartPlaceholdingSpace);


        names[17].setText("Mehrwertsteuer");
        textFields[17].setValue(BigDecimal.valueOf(19));
        textFields[17].setLabel("Satz");
        textFields[17].setSuffixComponent(new Span("%"));

        names[18].setText("Bruttoverkaufspreis");
        placeholder[18].setWidth(standartPlaceholdingSpace);

        calculate.setText("Berechnen");
        calculate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        calculate.setWidthFull();
    }

    public Double getValue(int position){
        if(textFields[position].getValue() == null){
            return null;
        }else if (position == 2 || position == 4 || position == 8 || position == 10 || position == 12 || position == 13 ||
        position == 15 || position == 17){
            return textFields[position].getValue().doubleValue() / 100;
        }
        else
        return textFields[position].getValue().doubleValue();
    }

    public void calculate (){
        calculation = new de.adesso.jani.Util.Handelskalkulation(getValue(0), getValue(1), getValue(2),
                getValue(3), getValue(4), getValue(5), getValue(6), getValue(7), getValue(8), getValue(9),
                getValue(10), getValue(11), getValue(12), getValue(13), getValue(14), getValue(15), getValue(16),
                getValue(17), getValue(18)
        );
        calculation.completeCalculation();
        System.out.println(Arrays.toString(calculation.getAllValues()));
        Double[] results = calculation.getAllValues();
        for(int i = 0; i < results.length; i++){
            if (i == 2 || i == 4 || i == 8 || i == 10 || i == 12 || i == 13 ||
                    i == 15 || i == 17){
                double result = results[i] * 100;
                textFields[i].setValue(BigDecimal.valueOf(result));
            }
            else
            textFields[i].setValue(BigDecimal.valueOf(results[i]));
        }
    }

}
