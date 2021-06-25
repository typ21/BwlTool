package de.adesso.jani.backend;

import com.helger.commons.hashcode.HashCodeGenerator;
import de.adesso.jani.backend.Util.TimeSpanData;
import javassist.ClassMap;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TimespanDataService {

    private final UsageDB uDB;

    @Autowired
    public TimespanDataService(UsageDB uDB){
        this.uDB = uDB;
    }

    public TimeSpanData getDataForTimeSpan(Period p) {

        LocalDate monthsback = LocalDate.now().minus(p);
        ArrayList<DayData> allData = uDB.findAll().stream().filter(dayData -> dayData.getDate().isAfter(monthsback)).collect(Collectors.toCollection(ArrayList::new));

        return new TimeSpanData(allData);
    }

}
