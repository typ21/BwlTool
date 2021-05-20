package de.adesso.jani.views.sites;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.Util.ChartGenerator;
import de.adesso.jani.views.OwnComponents.Card;
import de.adesso.jani.views.OwnComponents.NumberCard;
import de.adesso.jani.views.OwnComponents.TabPages;
import de.adesso.jani.views.main.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

@Route(value="admin", layout= MainView.class)
//@Secured("ROLE_ADMIN")
@PageTitle("Adminpanel")
public class Adminpanel extends VerticalLayout{

    HorizontalLayout hlNumberCards = new HorizontalLayout();
    NumberCard visitorsCard = new NumberCard();
    NumberCard calculationsCard = new NumberCard();
    NumberCard badCalculationsCard = new NumberCard();

    Card visitorsOverTime = new Card();

    public Adminpanel(){
        settings();
        listener();
        build();
    }

    private void build() {
        hlNumberCards.add(visitorsCard, calculationsCard, badCalculationsCard);
        add(hlNumberCards, visitorsOverTime);
    }

    private void listener() {
    }

    private void settings() {
        this.getStyle().set("background-color", "#f0f0f0");
        this.setMinHeight("100%");
        hlNumberCards.setWidthFull();
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
        settingVoT();
    }

    private void settingVoT() {
        TabPages tabpages = new TabPages();
        VerticalLayout page1 = tabpages.createPage("letzte Woche");
        VerticalLayout page2 = tabpages.createPage("letzter Monat");
        tabpages.selectTab(0);
        page1.add(ChartGenerator.createColumnCartWeek());
        page2.add(ChartGenerator.createColumnCartMonth());
        visitorsOverTime.add(tabpages);
    }
}
