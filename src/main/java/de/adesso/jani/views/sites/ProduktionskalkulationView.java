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
import de.adesso.jani.Util.Produktionskalkulation;
import de.adesso.jani.views.main.MainView;

import java.math.BigDecimal;

@Route(value="produktionskalkulation", layout= MainView.class)
@PageTitle("Produktionskalkulation")
public class ProduktionskalkulationView extends VerticalLayout {
    private HorizontalLayout[] hl;
    private VerticalLayout[] vls;
    private Text[] names;
    private BigDecimalField[] zuschlagssaetze;
    private BigDecimalField[] zuschlag;
    private BigDecimalField[] wert;
    private Div[] placeholder;

    private Button calculate;
    public ProduktionskalkulationView(){
        createObjects();
        settings();
        listener();
        build();
    }

    private void build() {
        for(int i = 0; i < hl.length; i++){
            Div div = new Div();
            div.setHeight("5px");
            div.setWidth("7px");
            vls[i].add(div, names[i]);
            if(i == 1 || i == 4 || i == 7 || i == 8 || i == 10 || i == 12 || i == 13 || i == 15 || i == 17){
                hl[i].add(vls[i], placeholder[i], zuschlagssaetze[i], zuschlag[i]);//vllt ohne placeholder für besseres Design
            }
            else
                hl[i].add(vls[i], placeholder[i], wert[i]);
            add(hl[i]);
        }
        add(calculate);
    }

    private void listener() {
        calculate.addClickListener(e -> calculate());
    }

    private void calculate() {
        Produktionskalkulation calc = new Produktionskalkulation(getValue(0, 0), getValue(1 , 1), getValue(1,2), getValue(2, 0), getValue(3, 0), getValue(4, 1), getValue(4, 2),
                getValue(5,0), getValue(6,0), getValue(7, 1), getValue( 7, 2), getValue(8, 1), getValue(8,2), getValue(9,0), getValue(10, 1), getValue(10, 2),
                getValue(11, 0), getValue(12,1), getValue(12 ,2), getValue(13,1), getValue(13,2), getValue(14, 0), getValue(15, 1), getValue(15, 2), getValue(16, 0),
                getValue(17, 1), getValue(17, 2), getValue(18, 0));
        calc.calcComplete();
        Double[][] soulution = calc.getAllValues();
        for(int i = 0; i < wert.length; i++){
            if(i == 1 || i == 4 || i == 7 || i == 8 || i == 10 || i == 12 || i == 13 || i == 15 || i == 17){
                double zuschlagssatz = soulution[i][0] * 100d;
                zuschlagssaetze[i].setValue(BigDecimal.valueOf(zuschlagssatz));
                zuschlag[i].setValue(BigDecimal.valueOf(soulution[i][1]));
            }
            else
                wert[i].setValue(BigDecimal.valueOf(soulution[i][2]));
        }
    }

    private void settings() {
        for(int i = 0; i < hl.length; i++) {
            hl[i].setWidthFull();
            vls[i].setAlignItems(Alignment.START);
            vls[i].setWidth("35%");
            placeholder[i].setHeight("50px");
            placeholder[i].setWidth("10px");
            if(i == 1 || i == 4 || i == 7 || i == 8 || i == 10 || i == 12 || i == 13 || i == 15 || i == 17) {
                zuschlagssaetze[i].setWidth("15%");
                zuschlagssaetze[i].setLabel("Zuschlagssatz");
                zuschlagssaetze[i].setSuffixComponent(new Span("%"));
                zuschlag[i].setWidth("20%");
                zuschlag[i].setLabel("Zuschlagssatz");
                zuschlag[i].setSuffixComponent(new Span("€"));
            }
            else {
                wert[i].setWidth("25%");
                wert[i].setLabel("Wert");
                wert[i].setSuffixComponent(new Span("€"));
            }
        }

        //Editable
        String standartPlaceholdingSpacex2 = "50%"; //Editable

        names[0].setText("Fertigungsmaterial");
        placeholder[0].setWidth(standartPlaceholdingSpacex2);

        names[1].setText("Materialgemeinkostenzuschlagssatz");

        names[2].setText("Materialkosten");
        placeholder[2].setWidth(standartPlaceholdingSpacex2);

        names[3].setText("Fertigungseinzelkosten/Fertigungslöhne");
        placeholder[3].setWidth(standartPlaceholdingSpacex2);

        names[4].setText("Fertigungsgemeinkostenzuschlagssatz");

        names[5].setText("Fertigungskosten");
        placeholder[5].setWidth(standartPlaceholdingSpacex2);

        names[6].setText("Herstellkosten der Prod.");
        placeholder[6].setWidth(standartPlaceholdingSpacex2);

        names[7].setText("Verwaltungsgemeinkostenzuschlag");

        names[8].setText("Vertriebsgemeinkostenzuschlagssatz");

        names[9].setText("Selbstkosten");
        placeholder[9].setWidth(standartPlaceholdingSpacex2);

        names[10].setText("Gewinnaufschlag");

        names[11].setText("Barverkaufsperis");
        placeholder[11].setWidth(standartPlaceholdingSpacex2);

        names[12].setText("Kundenskonto");

        names[13].setText("Verkaufsprovision");
        zuschlagssaetze[13].setValue(BigDecimal.valueOf(0));

        names[14].setText("Zielverkaufpreis");
        placeholder[14].setWidth(standartPlaceholdingSpacex2);

        names[15].setText("Kundenrabatt");

        names[16].setText("Listenpreis");
        placeholder[16].setWidth(standartPlaceholdingSpacex2);


        names[17].setText("Mehrwertsteuer");
        zuschlagssaetze[17].setValue(BigDecimal.valueOf(19));

        names[18].setText("Bruttoverkaufspreis");
        placeholder[18].setWidth(standartPlaceholdingSpacex2);

        calculate.setText("Berechnen");
        calculate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        calculate.setWidthFull();
    }

    private void createObjects() {
        hl = new HorizontalLayout[19];
        names = new Text[19];
        zuschlagssaetze = new BigDecimalField[19];
        zuschlag = new BigDecimalField[19];
        wert = new BigDecimalField[19];
        placeholder = new Div[19];
        calculate = new Button();
        vls = new VerticalLayout[19];
        for(int i = 0; i < hl.length; i++){
            hl[i] = new HorizontalLayout();
            vls[i] = new VerticalLayout();
            names[i] = new Text("");
            placeholder[i] = new Div();
            if(i == 1 || i == 4 || i == 7 || i == 8 || i == 10 || i == 12 || i == 13 || i == 15 || i == 17){
                zuschlagssaetze[i] = new BigDecimalField();
                zuschlag[i] = new BigDecimalField();
            }
            else
                wert[i] = new BigDecimalField();
        }
    }

    private Double getValue(int i, int j){
        assert(i < 20);
        assert(j < 3);
        if(j == 0 && wert[i].getValue() != null){
            return wert[i].getValue().doubleValue();
        }
        else if(j == 1 && zuschlagssaetze[i].getValue() != null){
            return zuschlagssaetze[i].getValue().doubleValue() / 100;
        }
        else if(j == 2 && zuschlag[i].getValue() != null){
            return zuschlag[i].getValue().doubleValue();
        }
        else return null;
    }

}
