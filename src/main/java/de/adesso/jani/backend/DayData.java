package de.adesso.jani.backend;

import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Entity
public class DayData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private Long totalClicks;

    @Temporal(value = TemporalType.DATE)
    private final Date date;

    private long clickCount;

    private long totalCalcs;
    private long totalFailedCalcs;
    private long totalSuccessCalcs;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> calcCounts;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> successCalcs;

    @ElementCollection
    private List<Long> failedCalcs;

    public DayData(Long previousClickCount){
        date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        this.totalClicks = previousClickCount;
        this.clickCount = 0L;
        this.totalSuccessCalcs = 0;
        this.totalFailedCalcs = 0;
        this.calcCounts = List.of(0L, 0L, 0L, 0L, 0L);
        this.successCalcs = List.of(0L, 0L, 0L, 0L, 0L);
        this.failedCalcs = List.of(0L, 0L, 0L, 0L, 0L);
    }

    public DayData() {
        this(0L);
    }


    public long getTotalCalcs() {
        return totalCalcs;
    }

    public void setTotalCalcs(long totalCalcs) {
        this.totalCalcs = totalCalcs;
    }

    public Long getTotalClicks() {
        return totalClicks;
    }
    public LocalDate getDate() {
       return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
    public void setTotalClicks(Long totalClicks) {
        this.totalClicks = totalClicks;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    public List<Long> getCalcCounts() {
        return calcCounts;
    }

    public void setCalcCounts(List<Long> calcCounts) {
        this.calcCounts = calcCounts;
    }

    public List<Long> getSuccessCalcs() {
        return successCalcs;
    }

    public void setSuccessCalcs(List<Long> successCalcs) {
        this.successCalcs = successCalcs;
    }

    public List<Long> getFailedCalcs() {
        return failedCalcs;
    }

    public void setFailedCalcs(List<Long> failedCalcs) {
        this.failedCalcs = failedCalcs;
    }

    public long getTotalFailedCalcs() {
        return totalFailedCalcs;
    }

    public void setTotalFailedCalcs(long totalFailedCalcs) {
        this.totalFailedCalcs = totalFailedCalcs;
    }

    public long getTotalSuccessCalcs() {
        return totalSuccessCalcs;
    }

    public void setTotalSuccessCalcs(long totalSuccessCalcs) {
        this.totalSuccessCalcs = totalSuccessCalcs;
    }
}
