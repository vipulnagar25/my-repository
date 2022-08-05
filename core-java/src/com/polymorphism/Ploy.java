package com.polymorphism;

class Parent {
    public static void test() {
        System.out.println("from-parent-class-test");
    }

}

public class Ploy extends Parent {

    public static void test() {
        System.out.println("from-ploy-class-test");
    }
    public static void main(String[] args) {
        Parent p1 = new Ploy();
        p1.test();
    }

}
