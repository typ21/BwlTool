package de.adesso.jani.views.sites;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.Util.ChartGenerator;
import de.adesso.jani.views.OwnComponents.Card;
import de.adesso.jani.views.OwnComponents.NumberCard;
import de.adesso.jani.views.OwnComponents.TabPages;
import de.adesso.jani.views.main.MainView;

@Route(value="admin", layout= MainView.class)
//@Secured("ROLE_ADMIN")
@PageTitle("Adminpanel")
public class Adminpanel extends VerticalLayout{

    HorizontalLayout hlNumberCards = new HorizontalLayout();
    NumberCard visitorsCard = new NumberCard();
    NumberCard calculationsCard = new NumberCard();
    NumberCard badCalculationsCard = new NumberCard();

    HorizontalLayout graphs = new HorizontalLayout();
    Card calculationOverTime = new Card();
    Card visitorsOverTime = new Card();

    public Adminpanel(){
        settings();
        build();
    }

    private void build() {
        hlNumberCards.add(visitorsCard, calculationsCard, badCalculationsCard);
        graphs.add(calculationOverTime, visitorsOverTime);
        add(hlNumberCards, graphs);
    }

    private void settings() {
        this.getStyle().set("background-color", "#f0f0f0");
        this.setMinHeight("100%");
        hlNumberCards.setWidthFull();
        graphs.setWidthFull();
        visitorsCard
                .setTitle("Heutige Besucher")
                .setDescription("Aufrufe der Homepage heute")
                .setType(visitorsCard.NORMAL)
                .setNumber(MainView.Visitors);
        calculationsCard
                .setTitle("Heutige Berechnungen")
                .setDescription("Berechnungen, die heute stattgefunden haben")
                .setType(badCalculationsCard.GOOD)
                .setNumber(13);
        badCalculationsCard
                .setTitle("Heute fehlgeschlagene Rechnungen")
                .setDescription("Anzahl der Berechnungen die heute fehlgeschlagen sind.")
                .setType(badCalculationsCard.WARNING)
                .setNumber(25);
        settingCoT();
        settingsVoT();
    }

    private void settingsVoT() {
        TabPages tabpages = new TabPages();
        VerticalLayout page1 = tabpages.createPage("Tag");
        VerticalLayout page2 = tabpages.createPage("Monat");
        tabpages.selectTab(0);
        page1.add(ChartGenerator.createCoTWeek());
        page2.add(ChartGenerator.createCoTMonth());
        calculationOverTime.add(tabpages);
    }

    private void settingCoT() {
        TabPages tabpages = new TabPages();
        VerticalLayout page1 = tabpages.createPage("Tag");
        VerticalLayout page2 = tabpages.createPage("Monat");
        tabpages.selectTab(0);
        page1.add(ChartGenerator.createVoTWeek());
        page2.add(ChartGenerator.createVoTMonth());
        visitorsOverTime.add(tabpages);
    }
}
