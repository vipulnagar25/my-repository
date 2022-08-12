package com.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void findAnagram(List<String> list) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str : list) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                } else {
                    tempMap.put(str.charAt(i), 1);
                }
            }
            if (map.containsKey(tempMap))
                map.get(tempMap).add(str);
            else {
                ArrayList<String>
                        tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }

        // Stores the result in a arraylist
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet())
            result.add(map.get(temp));
        System.out.println(result);
    }


    public static void main(String[] args) {
        String array[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        findAnagram(List.of(array));

    }

}
