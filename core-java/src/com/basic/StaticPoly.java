package com.basic;

public class StaticPoly {

    public void test(int a, int b) {
        System.out.println(a + b + "some of two variable");

    }

    public void test(int a, int b, String s) {
        System.out.println(a + b + "some of two variable" + "  " + s);

    }

    public static void main(String[] args) {
        StaticPoly staticPoly = new StaticPoly();
        staticPoly.test(1, 2);
        staticPoly.test(1, 2, "staticpoly");

    }

}
