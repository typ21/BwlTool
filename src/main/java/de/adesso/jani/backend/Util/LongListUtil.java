package de.adesso.jani.backend.Util;

import java.util.List;

public class LongListUtil {

    public static void incrementIndex(List<Long> list, int index){
        list.set(index, list.get(index)+1L);
    }

    public static long listSum(List<Long> data) {
        return data.stream().reduce(0L, Long::sum, Long::sum);
    }
}
