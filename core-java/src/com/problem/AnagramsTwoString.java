package com.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramsTwoString {
    private static int CHARACTER_RANGE= 256;

    public static boolean   isAnagramCounting(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
               // System.out.println(i+"vipul");
                 return false;
            }
        }
        return true;
    }
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
            System.out.println(map.values().stream().anyMatch(e->e>1));
            System.out.println(map);
            System.out.println(true);
        }

    }

    public static void main(String[] args) {
        isAnagramCounting("table","tbael");
        isAnagrams("tea", "aee");
       // Arrays.sort();
    }
}
