package com.problem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KFrequentNumbers {
    public static void frequentNumber(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], value + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        System.out.println(map);
        Map<Integer, Integer> finalMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue() == o2.getValue()) {
                        return o2.getKey() - o1.getKey();
                    } else {
                        return o2.getValue() - o1.getValue();
                    }
                }).forEach(e -> finalMap.put(e.getKey(), e.getValue()));
        AtomicInteger atomicInteger = new AtomicInteger(k);
        finalMap.forEach((key, value) -> {
            if (atomicInteger.get() > 0) {
                System.out.print(key + " ");
                atomicInteger.set(atomicInteger.get() - 1);
            }
        });
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int K = 4;
        frequentNumber(arr, K);
    }
}
