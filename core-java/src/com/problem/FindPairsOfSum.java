package com.problem;

import java.util.HashMap;
import java.util.Map;

public class FindPairsOfSum {
    static void findSomeOfTwoArray(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 0);
            }

        }
        int twice=0;
        for(int i = 0; i < array.length; i++) {
            if(map.containsKey(sum-array[i])) {
                twice+=map.get(sum-array[i]);
            } else {
               twice--;
            }

        }
        System.out.println("Number of fair :: " + ans);
        System.out.println("Number of new approach :: " + twice/2);


    }

    public static void main(String[] args) {
        int[] array = {1, 1};
        int sum = 2;
        findSomeOfTwoArray(array, sum);

    }
}
