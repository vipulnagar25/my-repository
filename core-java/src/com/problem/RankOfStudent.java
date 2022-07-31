package com.problem;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RankOfStudent {

    public static void main(String[] args) {
        int[] array = {100, 94, 96};
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);

            }

        }
        System.out.println(map);
    }

}
