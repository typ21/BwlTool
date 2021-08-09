package de.adesso.jani.views.sites.Interfaces;

import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.charts.model.ListSeries;
import de.adesso.jani.backend.DataService;
import de.adesso.jani.backend.TimespanDataService;
import de.adesso.jani.backend.Util.LongListUtil;
import de.adesso.jani.backend.Util.TimeSpanData;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.Period;
import java.util.Arrays;
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
        List<Long> data = tds.getDataForTimeSpan(Period.of(0, 0 , 7)).getSuccessADay();

        return new ListSeries("erfolgreiche Berechnungen", (Long[])data.toArray());
    }


    public ListSeries getSucCalMonth(){
        List<Long> data = tds.getDataForTimeSpan(Period.of(1, 0, 0)).getSuccessADay();

        return new ListSeries("erfolgreiche Berechnungen", LongListUtil.addUpMonths(data));
    }


    public ListSeries getBadCalDay(){
        List<Long> data = tds.getDataForTimeSpan(Period.of(0,0,7)).getFailsADay();

        return new ListSeries("fehlgeschlagene Berechnungen", (Long[])data.toArray());
    }


    public ListSeries getBadCalMonth(){
        List<Long> data = tds.getDataForTimeSpan(Period.of(1, 0, 0)).getFailsADay();

        return new ListSeries("fehlgeschlagene Berechnungen", LongListUtil.addUpMonths(data));
    }


    public DataSeries getVisitorsDay(){
        List<Long> data = tds.getDataForTimeSpan(Period.of(0, 0, 7)).getClicksADay();

        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData((Long[])data.toArray());

        return ds;
    }


    public DataSeries getVisitorsMonth(){
        List<Long> data = tds.getDataForTimeSpan(Period.of(1, 0, 0)).getClicksADay();

        DataSeries ds = new DataSeries();
        ds.setName("Besucher");
        ds.setData(LongListUtil.addUpMonths(data));

        return ds;
    }


    public int getVisitorsToday() {
        return (int) ds.getClicksToday();
    }


    public int getCalculationsToday() {
        return (int) ds.getTotalCalcCount();
    }


    public int getBadCalculationsToday() {
        return (int) ds.getTotalFail();
    }

}
