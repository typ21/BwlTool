package de.adesso.jani.Util;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;

public class ChartGenerator {

    public static Chart createCoTWeek() {
        Chart chart = new Chart();

        //configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Berechnungen der letzten Woche");
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

    public static Chart createCoTMonth() {
        Chart chart = new Chart();

        //configuration
        Configuration conf = chart.getConfiguration();
        conf.setTitle("Berechnungen des letzten Monats");
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

    public static Chart createVoTWeek() {
        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();
        conf.getChart().setType(ChartType.LINE);

        conf.getTitle().setText("Besucher der letzten Woche");

        XAxis x = new XAxis();
        x.setCategories("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag");
        conf.addxAxis(x);

        YAxis yAxis = conf.getyAxis();
        yAxis.setTitle(new AxisTitle("Besucher"));

        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(5, 6, 4, 6, 7, 3 ,9);
        conf.addSeries(ds);

        Tooltip tooltip = new Tooltip();
        tooltip.setShared(true);
        conf.setTooltip(tooltip);

        return chart;
    }

    public static Chart createVoTMonth() {
        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();
        conf.getChart().setType(ChartType.LINE);

        conf.getTitle().setText("Besucher im letzten Monat");

        XAxis x = new XAxis();
        x.setCategories("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember");
        conf.addxAxis(x);

        YAxis yAxis = conf.getyAxis();
        yAxis.setTitle(new AxisTitle("Besucher"));

        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);
        conf.addSeries(ds);

        Tooltip tooltip = new Tooltip();
        tooltip.setShared(true);
        conf.setTooltip(tooltip);

        return chart;
    }
}
