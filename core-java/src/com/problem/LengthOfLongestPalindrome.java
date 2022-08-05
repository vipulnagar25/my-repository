package com.problem;

public class LengthOfLongestPalindrome {

    public static void findMaxLength(String s1) {
        boolean[][] newArray = new boolean[s1.length()][s1.length()];
        int maxLength = 1;
        for (int i = 0; i < s1.length(); i++) {
            newArray[i][i] = true;
        }
        int start = 0;
        for (int i = 0; i < s1.length() - 1; ++i) {
            if (s1.charAt(i) == s1.charAt(i + 1)) {
                newArray[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= s1.length(); ++k) {

            for (int i = 0; i < s1.length() - k + 1; ++i) {

                int j = i + k - 1;

                if (newArray[i + 1][j - 1] && s1.charAt(i) == s1.charAt(j)) {
                    newArray[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println(maxLength);
        printArray(newArray);
    }

    public static void printArray(boolean[][] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                System.out.print(newArray[i][j] + "  ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        findMaxLength("geekssk");
    }
}
