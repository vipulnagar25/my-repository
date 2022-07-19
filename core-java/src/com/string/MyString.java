package com.string;

public class MyString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc").intern();
        String s4 = new String("abc");
      //  String s3 = s2.intern();
        System.out.println(s1==s2);
       // System.out.println(s1==s3);
       // System.out.println(s2==s3);
        System.out.println(s2==s4);
        String s5=String.valueOf("abc");
        System.out.println(s1==s5);
       // Integer.valueOf(s1);
       int j= Integer.valueOf(1);
       int n=1;
        System.out.println(j==n);
    }
}
