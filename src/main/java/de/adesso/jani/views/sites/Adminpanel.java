package de.adesso.jani.views.sites;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.NumberCard;
import de.adesso.jani.views.OwnComponents.TabPages;
import de.adesso.jani.views.main.MainView;
import org.springframework.security.access.annotation.Secured;

@Route(value="admin", layout= MainView.class)
//@Secured("ROLE_ADMIN")
@PageTitle("Adminpanel")
public class Adminpanel extends VerticalLayout {

    Board board = new Board();

    NumberCard visitorsCard = new NumberCard();

    Div visitorsOverTime = new Div();

    public Adminpanel(){
        settings();
        listener();
        build();
    }

    private void build() {
        board.addRow(visitorsCard);
        board.addRow(visitorsOverTime);
        add(board);
    }

    private void listener() {
    }

    private void settings() {
        this.getStyle().set("background-color", "#f0f0f0");
        visitorsCard
                .setTitle("Heutige Besucher")
                .setDescription("Aufrufe der Homepage heute")
                .setType(visitorsCard.NORMAL)
                .setNumber(MainView.Visitors);
        settingVoT();
    }

    private void settingVoT() {
        TabPages tabpages = new TabPages();
        VerticalLayout page1 = tabpages.createPage("letzte Woche");
        VerticalLayout page2 = tabpages.createPage("letzter Monat");
        tabpages.selectTab(0);
        page1.add(createColumnCartWeek());
        visitorsOverTime.add(tabpages);
    }

    private Chart createColumnCartWeek() {
        Chart chart = new Chart();

        //configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Besucher der letzten Woche");
        conf.getChart().setType(ChartType.COLUMN);

        //Daten
        conf.addSeries(new ListSeries("erfolgreiche Berechnungen", 5, 6, 4, 6, 7, 3 ,9));
        conf.addSeries(new ListSeries("fehlgeschlagene Berechnungen", 3, 8, 9, 13, 2, 0 ,7));

        //Achsenbeschriftung
        XAxis x = new XAxis();
        //x.setCrosshair(new Crosshair());
        x.setCategories("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag");
        conf.addxAxis(x);




        return chart;
    }
}
