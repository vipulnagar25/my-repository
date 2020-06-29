package com;

import java.util.HashMap;
import java.util.Map;

public class Testing {
    Map<String, Map<Double, Integer>> map = new HashMap<>();
    public void putNewRating(String movie, double rating) {
        if (!map.containsKey(movie)) {
            Map<Double, Integer> map1 = new HashMap<>();
            map1.put(rating, 1);
            map.put(movie, map1);
        } else {
            Double[] dd={0.0};
            Integer [] ii={1};
            map.get(movie).forEach((k, v) -> {
                dd[0]=k+rating;
                ii[0]=ii[0]+v;
            });
            Map<Double, Integer> map2 = new HashMap<>();
            map2.put(dd[0], ii[0]);

            map.put(movie, map2);
        }
    }
    public static void main(String[] args) {
        Map<String, Map<Double, Integer>> map = new HashMap<>();
        Testing dd=new Testing();
        dd.putNewRating("fff",22.33);
        dd.putNewRating("fff",22.33);
        dd.putNewRating("fff",22.33);

    }
}

