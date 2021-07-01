package de.adesso.jani.views.sites.Interfaces;

import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.ListSeries;
import de.adesso.jani.backend.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPanelInterface {

    @Autowired
    private final DataService ds;

    public AdminPanelInterface(DataService ds){
        this.ds = ds;
    }

    public ListSeries getSucCalDay(){
        return new ListSeries("erfolgreiche Berechnungen", 5, 6, 4, 6, 7, 3 ,9);
    }
    public ListSeries getSucCalMonth(){
        return new ListSeries("erfolgreiche Berechnungen", 3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);
    }

    public ListSeries getBadCalDay(){
        return new ListSeries("fehlgeschlagene Berechnungen", 5, 6, 4, 6, 7, 3 ,9);
    }
    public ListSeries getBadCalMonth(){
        return new ListSeries("fehlgeschlagene Berechnungen", 5, 6, 4, 6, 7, 3 ,9, 8 ,3, 7, 2, 4);
    }

    public DataSeries getVisitorsDay(){
        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(3, 8, 9, 13, 2, 0 ,7);
        return ds;
    }

    public DataSeries getVisitorsMonth(){
        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);
        return ds;
    }


    public int getVisitorsToday() {
        return (int) ds.getClicksToday();
    }

    public int getCalculationsToday() {
        return 0;
    }

    public int getBadCalculationsToday() {
        return 0;
    }
}
