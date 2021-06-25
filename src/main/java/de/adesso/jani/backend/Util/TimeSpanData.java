package de.adesso.jani.backend.Util;

import de.adesso.jani.backend.DataService;
import de.adesso.jani.backend.DayData;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class TimeSpanData {

    private List<Long> totalClickDevelopment;
    private List<Long> clicksADay;
    private List<Long> calculationsADay;

    private List<Long> abcADay;
    private List<Long> abcSuccess;
    private List<Long> abcFails;

    private List<Long> babADay;
    private List<Long> babSuccess;
    private List<Long> babFails;

    private List<Long> hanCalcADay;
    private List<Long> hanCalcSuccess;
    private List<Long> hanCalcFails;

    private List<Long> netADay;
    private List<Long> netSuccess;
    private List<Long> netFails;

    private List<Long> prodCalcADay;
    private List<Long> prodCalcSuccess;
    private List<Long> prodCalcFails;

    public TimeSpanData(ArrayList<DayData> collect) {

        collect.stream().sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate())).forEach( dayData ->
                {
                    totalClickDevelopment.add(dayData.getTotalClicks());
                    clicksADay.add(dayData.getClickCount());
                    calculationsADay.add(dayData.getTotalCalcs());

                    abcADay.add(dayData.getCalcCounts().get(DataService.ABCIndex));
                    abcSuccess.add(dayData.getSuccessCalcs().get(DataService.ABCIndex));
                    abcFails.add(dayData.getFailedCalcs().get(DataService.ABCIndex));

                    babADay.add(dayData.getCalcCounts().get(DataService.BABIndex));
                    babSuccess.add(dayData.getSuccessCalcs().get(DataService.BABIndex));
                    babFails.add(dayData.getFailedCalcs().get(DataService.BABIndex));

                    prodCalcADay.add(dayData.getCalcCounts().get(DataService.PRODIndex));
                    prodCalcSuccess.add(dayData.getSuccessCalcs().get(DataService.PRODIndex));
                    prodCalcFails.add(dayData.getFailedCalcs().get(DataService.PRODIndex));

                    netADay.add(dayData.getCalcCounts().get(DataService.NETIndex));
                    netSuccess.add(dayData.getSuccessCalcs().get(DataService.NETIndex));
                    netFails.add(dayData.getFailedCalcs().get(DataService.NETIndex));

                    hanCalcADay.add(dayData.getCalcCounts().get(DataService.HAKIndex));
                    hanCalcSuccess.add(dayData.getSuccessCalcs().get(DataService.HAKIndex));
                    hanCalcFails.add(dayData.getFailedCalcs().get(DataService.HAKIndex));

                }
        );

    }

    public List<Long> getTotalClickDevelopment() {
        return totalClickDevelopment;
    }

    public List<Long> getClicksADay() {
        return clicksADay;
    }

    public List<Long> getCalculationsADay() {
        return calculationsADay;
    }

    public List<Long> getAbcADay() {
        return abcADay;
    }

    public List<Long> getAbcSuccess() {
        return abcSuccess;
    }

    public List<Long> getAbcFailures() {
        return abcFails;
    }

    public List<Long> getBabADay() {
        return babADay;
    }

    public List<Long> getBabSuccess() {
        return babSuccess;
    }

    public List<Long> getBabFail() {
        return babFails;
    }

    public List<Long> getHanCalcADay() {
        return hanCalcADay;
    }

    public List<Long> getHanCalcSuccess() {
        return hanCalcSuccess;
    }

    public List<Long> getHanCalcFail() {
        return hanCalcFails;
    }

    public List<Long> getNetADay() {
        return netADay;
    }

    public List<Long> getNetSSuccess() {
        return netSuccess;
    }

    public List<Long> getNetFails() {
        return netFails;
    }

    public List<Long> getProdCalcADay() {
        return prodCalcADay;
    }

    public List<Long> getProdCalcSuccess() {
        return prodCalcSuccess;
    }

    public List<Long> getProdCalcFail() {
        return prodCalcFails;
    }
}
