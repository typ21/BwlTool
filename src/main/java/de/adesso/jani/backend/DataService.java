package de.adesso.jani.backend;

import de.adesso.jani.backend.Util.LongListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class DataService {

    public static final int ABCIndex = 0;
    public static final int BABIndex = 1;
    public static final int HAKIndex = 2;
    public static final int NETIndex = 3;
    public static final int PRODIndex = 4;


    private final UsageDB uDB;
    private DayData currentEntityBuffer;

    @Autowired
    public DataService(UsageDB db){

        this.uDB = db;

        db.getDayDataByDate(LocalDate.now()).ifPresentOrElse(this::setCurrentEntityBuffer, this::initToday);

    }

    public long getTotalClicks() {
        return currentEntityBuffer.getTotalClicks();
    }

    public long getClicksToday() {
        return currentEntityBuffer.getClickCount();
    }

    public void incrementTotalClicks(){
        currentEntityBuffer.setTotalClicks(currentEntityBuffer.getTotalClicks()+1);
        this.currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public void incrementTodayClicks() {
        currentEntityBuffer.setClickCount(currentEntityBuffer.getClickCount());
        this.currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public long getTotalCalcCount() {
       return currentEntityBuffer.getTotalCalcs();
    }

    /*-----ABC-Anal-----*/

    public synchronized void incrementABC(boolean success) {

        LongListUtil.incrementIndex(currentEntityBuffer.getCalcCounts(), ABCIndex);

        if(success)
            LongListUtil.incrementIndex(currentEntityBuffer.getSuccessCalcs(), ABCIndex);
        else
            LongListUtil.incrementIndex(currentEntityBuffer.getFailedCalcs(), ABCIndex);

        currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public long getABCCount(){
        return currentEntityBuffer.getCalcCounts().get(ABCIndex);
    }

    public long getABCFail() {
        return currentEntityBuffer.getFailedCalcs().get(ABCIndex);
    }

    public long getABCSuccess() {
        return currentEntityBuffer.getSuccessCalcs().get(ABCIndex);
    }


    /*-----BAB-----*/

    public synchronized void incrementBAB(boolean success) {

        LongListUtil.incrementIndex(currentEntityBuffer.getCalcCounts(), BABIndex);

        if(success)
            LongListUtil.incrementIndex(currentEntityBuffer.getSuccessCalcs(), BABIndex);
        else
            LongListUtil.incrementIndex(currentEntityBuffer.getFailedCalcs(), BABIndex);

        currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public long getBABCount(){
        return currentEntityBuffer.getCalcCounts().get(BABIndex);
    }

    public long getBABFail() {
        return currentEntityBuffer.getFailedCalcs().get(BABIndex);
    }

    public long getBABSuccess() {
        return currentEntityBuffer.getSuccessCalcs().get(BABIndex);
    }

    /*-----Handels-----*/

    public synchronized void incrementHanKalk(boolean success) {

        LongListUtil.incrementIndex(currentEntityBuffer.getCalcCounts(), HAKIndex);

        if(success)
            LongListUtil.incrementIndex(currentEntityBuffer.getSuccessCalcs(), HAKIndex);
        else
            LongListUtil.incrementIndex(currentEntityBuffer.getFailedCalcs(), HAKIndex);

        currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public long getHanKalkCount(){
        return currentEntityBuffer.getCalcCounts().get(HAKIndex);
    }

    public long getHanKalkFail() {
        return currentEntityBuffer.getFailedCalcs().get(HAKIndex);
    }

    public long getHanKalkSuccess() {
        return currentEntityBuffer.getSuccessCalcs().get(HAKIndex);
    }

    /*-----Netplan-----*/

    public void incrementNET(boolean success) {

        LongListUtil.incrementIndex(currentEntityBuffer.getCalcCounts(), NETIndex);

        if(success)
            LongListUtil.incrementIndex(currentEntityBuffer.getSuccessCalcs(), NETIndex);
        else
            LongListUtil.incrementIndex(currentEntityBuffer.getFailedCalcs(), NETIndex);

        currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public long getNETCount(){
        return currentEntityBuffer.getCalcCounts().get(NETIndex);
    }

    public long getNETFail() {
        return currentEntityBuffer.getFailedCalcs().get(NETIndex);
    }

    public long getNETSuccess() {
        return currentEntityBuffer.getSuccessCalcs().get(NETIndex);
    }

    /*-----Produktion-----*/

    public void incrementProdKalk(boolean success) {

        LongListUtil.incrementIndex(currentEntityBuffer.getCalcCounts(), PRODIndex);

        if(success)
            LongListUtil.incrementIndex(currentEntityBuffer.getSuccessCalcs(), PRODIndex);
        else
            LongListUtil.incrementIndex(currentEntityBuffer.getFailedCalcs(), PRODIndex);

        currentEntityBuffer = uDB.saveAndFlush(currentEntityBuffer);
    }

    public long getProdKalkCount(){
        return currentEntityBuffer.getCalcCounts().get(PRODIndex);
    }

    public long getProdKalkFail() {
        return currentEntityBuffer.getFailedCalcs().get(PRODIndex);
    }

    public long getProdKalkSuccess() {

        return currentEntityBuffer.getSuccessCalcs().get(PRODIndex);
    }



    @Scheduled(cron = "0 0 0 * * ?")
    private void initToday() {

        DayData previous = uDB.getDayDataByDate(LocalDate.now().minus(Period.ofDays(1))).orElseGet(
                () -> {
                    return uDB.findAll().stream().max((o1, o2) -> {
                        return o1.getDate().compareTo(o2.getDate());
                    }).orElse(null);
                }
                );

        long totalClicks = (previous != null) ? previous.getTotalClicks() : 0L;

        DayData current = new DayData(totalClicks);

        this.currentEntityBuffer = uDB.saveAndFlush(current);
    }

    private void setCurrentEntityBuffer(DayData dd){
        this.currentEntityBuffer = dd;
    }
}
