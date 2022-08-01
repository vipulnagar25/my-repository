package com.problem;

public class LongestPalindrome {
    public static void printAllSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int length = s.substring(i, j).length();
                if (res < length)
                    res = length;
                //s.substring(i, j)
                System.out.println(s.substring(i, j));

            }

        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        printAllSubstring(str);
    }
}
