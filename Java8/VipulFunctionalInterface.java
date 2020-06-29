package com.Java8;

public interface VipulFunctionalInterface {

    static void doSomeMoreWork1() {
        System.out.println("from VipulFunctionalInterface");
    }

    default void doSomeMoreWork() {

        System.out.println("doSomeMoreWork3");

    }

    public static void main(String[] args) {
        VipulFunctionalInterface.doSomeMoreWork1();

        System.out.println("sss");
    }

    @Override
    public String toString();
}
