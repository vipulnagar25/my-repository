package com.problem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurrences {
    public static void occurrences(String str) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(countMap.containsKey(str.charAt(i))) {
                int count = countMap.get(str.charAt(i));
                countMap.put(str.charAt(i), count + 1);
            } else {
                countMap.put(str.charAt(i), 1);
            }
        }
        Map<Character, Integer> result = countMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, newValue) -> o1, LinkedHashMap::new));
        result.forEach((key, value) -> {
            System.out.println(key + "::" + value);
        });

        // this is old concept
       /*Map.Entry entry=countMap.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue())).collect(e->Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        // countMap.keySet().stream().sorted((o1, o2) -> o1.compareTo(o2.charValue())));
        System.out.println(entry);
        countMap.forEach((key, value) -> {
             System.out.println(key + ":::" + value);
        });
*/
        //   System.out.println(countMap);

    }

    public static void main(String[] args) {
        String str = "012345567676733112245678";
        occurrences(str);
    }

}
