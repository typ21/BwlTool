package de.adesso.jani.views.sites.Interfaces;

import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.charts.model.ListSeries;
import de.adesso.jani.backend.DataService;
import de.adesso.jani.backend.TimespanDataService;
import de.adesso.jani.backend.Util.TimeSpanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class AdminPanelInterface {

    @Autowired
    private final DataService ds;
    @Autowired
    private  final TimespanDataService tds;

    public AdminPanelInterface(DataService ds, TimespanDataService tds){
        this.tds = tds;
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
        List<Long> data = tds.getDataForTimeSpan(Period.of(0, 0, 7)).getClicksADay();

        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData((Number) data);
        return ds;
    }

    public DataSeries getVisitorsMonth(){
        //Anfrage nicht richig
        //List<Long> data = tds.getDataForTimeSpan(Period.of(0, 0, 7));

        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(3, 8, 9, 13, 2, 0 ,7, 4, 8, 6, 7, 9);
        return ds;
    }


    public int getVisitorsToday() {
        return (int) ds.getClicksToday();
    }

    public int getCalculationsToday() {
        TimeSpanData tsd = tds.getDataForTimeSpan(Period.of(0,0,1));
        long cal = tsd.getCalculationsADay().stream().findFirst().get();
        return (int) cal;
    }

    public int getBadCalculationsToday() {
        //Anfrage stimmt noch nicht
        TimeSpanData tsd = tds.getDataForTimeSpan(Period.of(0,0,1));
        long cal = tsd.getCalculationsADay().stream().findFirst().get();
        return (int) cal;
    }
}
