package de.adesso.jani.backend.Util;

import de.adesso.jani.backend.DataService;
import de.adesso.jani.backend.DayData;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class TimeSpanData {

    private final List<Long> totalClickDevelopment;
    private final List<Long> clicksADay;
    private final List<Long> calculationsADay;
    private final List<Long> failsADay;
    private final List<Long> successADay;

    private final List<Long> abcADay;
    private final List<Long> abcSuccess;
    private final List<Long> abcFails;

    private final List<Long> babADay;
    private final List<Long> babSuccess;
    private final List<Long> babFails;

    private final List<Long> hanCalcADay;
    private final List<Long> hanCalcSuccess;
    private final List<Long> hanCalcFails;

    private final List<Long> netADay;
    private final List<Long> netSuccess;
    private final List<Long> netFails;

    private final List<Long> prodCalcADay;
    private final List<Long> prodCalcSuccess;
    private final List<Long> prodCalcFails;

    public TimeSpanData(ArrayList<DayData> collect) {

        this.totalClickDevelopment = new ArrayList<Long>();
        this.clicksADay = new ArrayList<Long>();
        this.calculationsADay = new ArrayList<Long>();
        this.failsADay = new ArrayList<Long>();
        this.successADay = new ArrayList<Long>();

        this.abcADay = new ArrayList<Long>();
        this.abcSuccess = new ArrayList<Long>();
        this.abcFails = new ArrayList<Long>();

        this.babADay = new ArrayList<Long>();
        this.babSuccess = new ArrayList<Long>();
        this.babFails = new ArrayList<Long>();

        this.hanCalcADay = new ArrayList<Long>();
        this.hanCalcSuccess = new ArrayList<Long>();
        this.hanCalcFails = new ArrayList<Long>();

        this.netADay = new ArrayList<Long>();
        this.netSuccess = new ArrayList<Long>();
        this.netFails = new ArrayList<Long>();

        this.prodCalcADay = new ArrayList<Long>();
        this.prodCalcSuccess = new ArrayList<Long>();
        this.prodCalcFails = new ArrayList<Long>();


        collect.stream().sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate())).forEach( dayData ->
                {
                    totalClickDevelopment.add(dayData.getTotalClicks());
                    clicksADay.add(dayData.getClickCount());
                    calculationsADay.add(dayData.getTotalCalcs());
                    successADay.add(dayData.getTotalSuccessCalcs());
                    failsADay.add(dayData.getTotalFailedCalcs());

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

    public List<Long> getFailsADay() {
        return failsADay;
    }

    public List<Long> getSuccessADay() {
        return successADay;
    }
}
