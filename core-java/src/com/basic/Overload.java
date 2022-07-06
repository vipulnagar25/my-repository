package com.basic;

public class Overload {
    public void test(int i) {
        System.out.println("print test 1p" + i);
    }

    public void test(int i, int j) {
        System.out.println("print test 1p" + i + j);
    }

    public String test(String s) {
        return s;
    }

    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.test(1);
        overload.test(1, 2);
        System.out.println(overload.test("vipul"));
    }
}
