package de.adesso.jani.views.sites;

import com.vaadin.flow.component.cookieconsent.CookieConsent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.WebBrowser;
import de.adesso.jani.views.OwnComponents.Card;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;
import de.adesso.jani.views.sites.Calculations.ABCAnalyseView;
import de.adesso.jani.views.sites.Calculations.BABView;

import java.util.ArrayList;

@CssImport("./views/home/home-view.css")
@Route(value = "", layout = MainView.class)
@PageTitle("Home")
public class HomeView extends VerticalLayoutWithFooter implements BeforeEnterObserver {

    ArrayList<HorizontalLayout> contents = new ArrayList<>();
    ArrayList<Card> cards = new ArrayList<>();

    H1 title = new H1("Willkommen im BWL Tool");

    CookieConsent dialog = new CookieConsent(
            "Wir benutzen Cookies für die bestmögliche Erfahrung.",
            "Einverstanden!", "Warum?", "https://vaadin.com/terms-of-service",
            CookieConsent.Position.BOTTOM);


    public HomeView(){
        createCards();
        addCardsToBoard();
        build();

    }

    private void build() {
        this.addClassName("backgroudcolorGrey");
        this.setAlignItems(Alignment.CENTER);
        add(title);
        for(HorizontalLayout hl : contents)
            add(hl);
        //add(dialog);
    }

    private void addCardsToBoard() {
        int columns = 1;
        if(!isMobileDevice())
            columns++;
        if(columns == 1)
            for(Card card : cards) {
                card.setWidth("98%");
                HorizontalLayout hl = new HorizontalLayout();
                hl.add(card);
                contents.add(hl);
            }
        else {
            boolean full = false;
            HorizontalLayout hl = new HorizontalLayout();
            for (Card card : cards) {
                if(full){
                    hl.add(card);
                    contents.add(hl);
                    hl = new HorizontalLayout();
                    full=false;
                }else{
                    hl.add(card);
                    full = true;
                }
            }
            contents.add(hl);
        }
    }

    private void createCards() {
        cards.add(Card.createCard()
                .setTitle("ABC-Analyse")
                .setDescription("Die ABC-Analyse kann Kunden oder Produkte in die Klassen A, B und C einordnen, was deren Wichtigkeit zeigt.")
                .setNavigationTarget(ABCAnalyseView.class));
        cards.add(Card.createCard()
                .setTitle("Betriebsabrechnungsbogen")
                .setDescription("Der Betriebsabrechnungsbigen (BAB) ist ein Werkzeug der internen Kostenrechnung. Mithilfe des BAB werden Gemeinkosten auf die unterschiedlichen Kostenstellen eines Unternehmens aufgeteilt. Gemeinkosten wie Beispielweise Strom, sind Kosten, welche nicht direkt einer Abteilung zugerechnet werden können. Diese Kosten werden entweder über Verteilungsschlüssel oder Verbrauchsinformationen auf die Kostenstellen verteilt. Die unterschiedlichen Unternehmensbereiche stellen die Kostenstellen im BAB dar. In diesen Beispielaufgaben sind dies die Bereiche Material, Fertigung, Vertrieb und Verwaltung.")
                .setNavigationTarget(BABView.class));
        cards.add(Card.createCard()
                .setTitle("Handelskalkulation")
                .setDescription("Mithilfe der Handelskalkulation werden die Verkaufspreise für Produkte festgelegt. Sie dient als Hilfsmittel für die Preisberechnung und Preissetzung. Für unterschiedliche Marktsituationen oder je nachdem welche Kennzahlen gesucht bzw. gegebenen sind, lassen sich unterschiedliche Kalkulationsarten durchführen: Vorwärts-, Rückwärts- oder einer Zwischenkalkulation, in der ein beliebiger Wert gesucht wird. Mit diesem Tool können alle voran genannten Kalkulationsarten geübt werden. Dabei werden Ihnen zufallsgenerierte Werte in einer Tabelle präsentiert und per Klick auch die entsprechende Musterlösung angezeigt. In einer Auswahlliste sind gezielt gewünschte Kennzahlen auswählbar.")
                .setNavigationTarget(BABView.class));
        cards.add(Card.createCard()
                .setTitle("Netplanrechner")
                .setDescription("Der Netzplanrechner kann Netzplanaufgaben lösen. Er nutzt das Tool netzplan-Service von projectcodingduck als Backend und ist erreichbar unter: https://github.com/projectcodingduck/netzplan-service")
                .setNavigationTarget(ABCAnalyseView.class));
        cards.add(Card.createCard()
                .setTitle("Produktionskalkulation")
                .setDescription("Mit diesem Aufgabengenerator lassen sich Aufgaben zur Durchführung einer Produktionskalkulation erstellen. Dabei kann zunächst ausgewählt werden, welches Feld zu berechnen ist. Es kann aber auch eingestellt werden, dass ein zufälliges Feld zu berechnen ist. Außerdem ist es vor dem Generieren der Aufgabe möglich den Mehrwertsteuersatz anzupassen, um entsprechend auf aktuelle Geschehnisse zu reagieren. Nach dem Lösen der Aufgabe kann der Wert des zu berechnenden Feldes eingegeben werden. Diese Eingabe wird durch den Aufgabengenerator überprüft. In diesem Zusammenhang wird auch die Musterlösung mit den Ergebnissen präsentiert.")
                .setNavigationTarget(ABCAnalyseView.class));
    }

    private boolean isMobileDevice() {
        WebBrowser webBrowser = VaadinSession.getCurrent().getBrowser();
        return webBrowser.isAndroid() || webBrowser.isIPhone() || webBrowser.isWindowsPhone();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        MainView.Visitors++;
    }

}
