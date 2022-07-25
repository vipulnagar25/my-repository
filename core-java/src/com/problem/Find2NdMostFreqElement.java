package com.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Find2NdMostFreqElement {

    public static void find2NdMostFreqElement(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        AtomicInteger firstElement = new AtomicInteger();
        firstElement.set(0);
        AtomicInteger secondElement = new AtomicInteger();
        secondElement.set(0);
        AtomicReference<String> s1 = new AtomicReference<>("");
//        map.forEach((key, value) -> {
//            if (value > firstElement.get()) {
//                secondElement.set(firstElement.get());
//                firstElement.set(value);
//                s1.set(key + "");
//            }  if (value > secondElement.get() && firstElement.get() != value) {
//                secondElement.set(value);
//                s1.set(key + "");
//            }
//            System.out.println(key + "::" + value);
//        });
        System.out.println(s1.get());
    }


    public static void main(String[] args) {
        String str = "ccss";
        find2NdMostFreqElement(str);
    }
}
