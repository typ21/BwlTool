package de.adesso.jani.views.sites;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;

@CssImport("./views/home/home-view.css")
@Route(value = "", layout = MainView.class)
@PageTitle("Home")
public class HomeView extends VerticalLayoutWithFooter implements BeforeEnterObserver {

    H1 titel = new H1("Willkommen im Bwl Tool!");
    H2 subtitle = new H2("Hier kannst du häufige Rechnungen in der Bwl leicht ausführen.");
    HorizontalLayout hlBoxen;
    HorizontalLayout hlBoxen2;
    VerticalLayout vlHandelskalkulation;
    VerticalLayout vlProduktionskalkulation;
    VerticalLayout vlBetriebsabrechnungsbogen;
    VerticalLayout vlAbc;
    VerticalLayout vlNetz;
    VerticalLayout vlHelp;
    RouterLink toHC;
    RouterLink toPC;
    RouterLink toABC;
    RouterLink toBAB;
    RouterLink toNetz;

    public HomeView() {
        objects();
        settings();
        listener();
        build();

    }

    private void build() {
        add(titel);
        hlBoxen.add(vlHandelskalkulation, vlProduktionskalkulation);
        vlHelp.add(vlAbc, vlNetz);
        hlBoxen2.add(vlBetriebsabrechnungsbogen, vlHelp);
        add(hlBoxen, hlBoxen2);

    }

    private void settings() {
        this.setAlignItems(Alignment.CENTER);
        hlBoxen.setWidth("90%");
        hlBoxen.setPadding(true);
        hlBoxen.setAlignItems(FlexComponent.Alignment.START);
        hlBoxen2.setWidth("90%");
        hlBoxen2.setPadding(true);
        hlBoxen2.setAlignItems(Alignment.START);
        vlProduktionskalkulation.setWidthFull();
        vlHandelskalkulation.setWidthFull();
        vlAbc.setWidthFull();
        vlProduktionskalkulation.setWidthFull();
        vlHandelskalkulation.getStyle().set("border", "1px solid #7f838a");
        vlProduktionskalkulation.getStyle().set("border", "1px solid #7f838a");
        vlAbc.getStyle().set("border", "1px solid #7f838a");
        vlBetriebsabrechnungsbogen.getStyle().set("border", "1px solid #7f838a");
        vlNetz.getStyle().set("border", "1px solid #7f838a");

        //Handelscalc
        vlHandelskalkulation.add(new H2("Handelskalkulation"));
        vlHandelskalkulation.add(new Span("Mithilfe der Handelskalkulation werden die Verkaufspreise für Produkte festgelegt. Sie dient als Hilfsmittel für die Preisberechnung und Preissetzung. Für unterschiedliche Marktsituationen oder je nachdem welche Kennzahlen gesucht bzw. gegebenen sind, lassen sich unterschiedliche Kalkulationsarten durchführen: Vorwärts-, Rückwärts- oder einer Zwischenkalkulation, in der ein beliebiger Wert gesucht wird. Mit diesem Tool können alle voran genannten Kalkulationsarten geübt werden. Dabei werden Ihnen zufallsgenerierte Werte in einer Tabelle präsentiert und per Klick auch die entsprechende Musterlösung angezeigt. In einer Auswahlliste sind gezielt gewünschte Kennzahlen auswählbar."));
        toHC = new RouterLink("Zur Handelskalkulation", HandelskalkulationView.class);
        vlHandelskalkulation.add(toHC);

        //Produktionscal
        vlProduktionskalkulation.add(new H2("Produktionskalkulation"));
        vlProduktionskalkulation.add(new Span("Mit diesem Aufgabengenerator lassen sich Aufgaben zur Durchführung einer Produktionskalkulation erstellen. Dabei kann zunächst ausgewählt werden, welches Feld zu berechnen ist. Es kann aber auch eingestellt werden, dass ein zufälliges Feld zu berechnen ist. Außerdem ist es vor dem Generieren der Aufgabe möglich den Mehrwertsteuersatz anzupassen, um entsprechend auf aktuelle Geschehnisse zu reagieren. Nach dem Lösen der Aufgabe kann der Wert des zu berechnenden Feldes eingegeben werden. Diese Eingabe wird durch den Aufgabengenerator überprüft. In diesem Zusammenhang wird auch die Musterlösung mit den Ergebnissen präsentiert."));
        toPC = new RouterLink("Zur Produktionskalkulation", ProduktionskalkulationView.class);
        vlProduktionskalkulation.add(toPC);

        //BAB
        vlBetriebsabrechnungsbogen.add(new H2("Betriebsabrechnungsbogen"));
        vlBetriebsabrechnungsbogen.add(new Span("Der Betriebsabrechnungsbigen (BAB) ist ein Werkzeug der internen Kostenrechnung. Mithilfe des BAB werden Gemeinkosten auf die unterschiedlichen Kostenstellen eines Unternehmens aufgeteilt. Gemeinkosten wie Beispielweise Strom, sind Kosten, welche nicht direkt einer Abteilung zugerechnet werden können. Diese Kosten werden entweder über Verteilungsschlüssel oder Verbrauchsinformationen auf die Kostenstellen verteilt. Die unterschiedlichen Unternehmensbereiche stellen die Kostenstellen im BAB dar. In diesen Beispielaufgaben sind dies die Bereiche Material, Fertigung, Vertrieb und Verwaltung."));
        toBAB = new RouterLink("Zum Betriebsabrechnungsbogen löser", BABView.class);
        vlBetriebsabrechnungsbogen.add(toBAB);

        //ABC
        vlAbc.add(new H2("ABC-Analyse"));
        vlAbc.add("Die ABC-Analyse kann Kunden oder Produkte in die Klassen A, B und C einordnen, was deren Wichtigkeit zeigt.");
        toABC = new RouterLink("Zur ABC Anlyse", ABCAnalyseView.class);
        vlAbc.add(toABC);

        //Netzplan
        vlNetz.add(new H2("Netzplanrechner"));
        vlNetz.add("Der Netzplanrechner kann Netzplanaufgaben lösen. Er nutzt das Tool netzplan-Service von projectcodingduck als Backend und ist erreichbar unter: https://github.com/projectcodingduck/netzplan-service");
        toNetz = new RouterLink("Zum Netzplanrechner", NetplanView.class);
        vlNetz.add(toNetz);
    }

    private void listener() {

    }

    private void objects() {
        vlHandelskalkulation = new VerticalLayout();
        vlProduktionskalkulation = new VerticalLayout();
        hlBoxen = new HorizontalLayout();
        hlBoxen2 = new HorizontalLayout();
        vlAbc = new VerticalLayout();
        vlBetriebsabrechnungsbogen = new VerticalLayout();
        vlNetz = new VerticalLayout();
        vlHelp = new VerticalLayout();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        MainView.Visitors++;
    }

}
