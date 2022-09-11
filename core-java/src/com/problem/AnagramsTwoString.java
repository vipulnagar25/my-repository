package com.problem;

import java.util.HashMap;
import java.util.Map;

public class AnagramsTwoString {
    public static void isAnagrams(String s1, String s2) {
        if (s1.length() != s1.length()) {
            System.out.println("not anagrams");

        } else {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                if (map.containsKey(s1.charAt(i))) {
                    int val = map.get(i);
                    map.put(s1.charAt(i), val + 1);
                } else {
                    map.put(s1.charAt(i), 1);

                }

            }
            for (int i = 0; i < s2.length(); i++) {
                if (map.containsKey(s2.charAt(i))) {
                    int val = map.get(s2.charAt(i));
                    map.put(s2.charAt(i), val - 1);
                } else {
                    map.put(s2.charAt(i), 1);

                }

            }
            System.out.println(map);
            System.out.println(true);
        }

    }

    public static void main(String[] args) {
        isAnagrams("tea", "aee");
    }
}
