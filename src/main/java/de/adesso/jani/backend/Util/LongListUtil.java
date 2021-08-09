package de.adesso.jani.backend.Util;

import java.util.List;

public class LongListUtil {

    private static final double conversionDaysAMonth = 365.0d / 12.0d;

    public static void incrementIndex(List<Long> list, int index){
        list.set(index, list.get(index)+1L);
    }

    public static long listSum(List<Long> data) {
        return data.stream().reduce(0L, Long::sum, Long::sum);
    }

    public static Long[] addUpMonths(List<Long> data) {
        Long[] longs = new Long[12];

        int startingIndex = 365 - data.size();
        int currentMonth = (int) Math.floor((double)startingIndex/conversionDaysAMonth);

        for(int i = startingIndex; i < 365; i++){
            longs[currentMonth]+=data.get(i);
            currentMonth = (int) Math.floor((double)i/conversionDaysAMonth);
        }
        return longs;
    }

}
