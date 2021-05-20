package de.adesso.jani.Util;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;

public class ChartGenerator {

    public static Chart createColumnCartWeek() {
        Chart chart = new Chart();

        //configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Besucher der letzten Woche");
        conf.getChart().setType(ChartType.COLUMN);

        //Daten
        ListSeries ls1 = new ListSeries("erfolgreiche Berechnungen", 5, 6, 4, 6, 7, 3 ,9);
        ListSeries ls2 = new ListSeries("fehlgeschlagene Berechnungen", 3, 8, 9, 13, 2, 0 ,7);

        conf.addSeries(ls1);
        conf.addSeries(ls2);

        //Achsenbeschriftung
        XAxis x = new XAxis();
        //x.setCrosshair(new Crosshair());
        x.setCategories("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag");
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        y.setTitle("Anzahl berechnungen");
        conf.addyAxis(y);

        //tooltip
        Tooltip tooltip = new Tooltip();
        tooltip.setShared(true);
        conf.setTooltip(tooltip);

        return chart;
    }

    public static Chart createColumnCartMonth() {
        Chart chart = new Chart();

        //configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Besucher der letzten Woche");
        conf.getChart().setType(ChartType.COLUMN);

        //Daten
        ListSeries ls1 = new ListSeries("erfolgreiche Berechnungen", 5, 6, 4, 6, 7, 3 ,9, 9, 3, 7, 7, 3);
        ListSeries ls2 = new ListSeries("fehlgeschlagene Berechnungen", 3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);

        conf.addSeries(ls1);
        conf.addSeries(ls2);

        //Achsenbeschriftung
        XAxis x = new XAxis();
        //x.setCrosshair(new Crosshair());
        x.setCategories("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember");
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        y.setTitle("Anzahl berechnungen");
        conf.addyAxis(y);

        //tooltip
        Tooltip tooltip = new Tooltip();
        tooltip.setShared(true);
        conf.setTooltip(tooltip);

        return chart;
    }

}
