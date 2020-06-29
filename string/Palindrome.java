package com.string;

public class Palindrome {
    public static boolean isPalindrome(String str) {
       /* // by for each loop
        String str1 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str1 = str1 + str.charAt(i);
        }
        System.out.println(str1.equals(str));*/
        boolean isPalindrome = true;
        for (int i = 0, j = str.length() - 1; j > i; i++, j--)
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
        return isPalindrome;
    }


    public static void main(String[] args) {
        System.out.println( isPalindrome("232"));

    }
}
