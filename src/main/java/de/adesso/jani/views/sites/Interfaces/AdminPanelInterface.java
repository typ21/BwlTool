package de.adesso.jani.views.sites.Interfaces;

import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.ListSeries;

public class AdminPanelInterface {

    public static ListSeries getSucCalDay(){
        return new ListSeries("erfolgreiche Berechnungen", 5, 6, 4, 6, 7, 3 ,9);
    }
    public static ListSeries getSucCalMonth(){
        return new ListSeries("erfolgreiche Berechnungen", 3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);
    }

    public static ListSeries getBadCalDay(){
        return new ListSeries("fehlgeschlagene Berechnungen", 5, 6, 4, 6, 7, 3 ,9);
    }
    public static ListSeries getBadCalMonth(){
        return new ListSeries("fehlgeschlagene Berechnungen", 5, 6, 4, 6, 7, 3 ,9, 8 ,3, 7, 2, 4);
    }

    public static DataSeries getVisitorsDay(){
        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(3, 8, 9, 13, 2, 0 ,7);
        return ds;
    }

    public static DataSeries getVisitorsMonth(){
        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);
        return ds;
    }


}
