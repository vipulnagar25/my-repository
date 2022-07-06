package com.java8;

@FunctionalInterface
interface Check1 {
    public int add(int x, int y);

}

public class MethodReference {
    public static int sum(int a, int b) {
        System.out.println("The sum is :" + (a + b));
        return (a + b);
    }

    public static String sum1(int a, int b) {
        System.out.println("The sum is :" + (a + b));
        return a + "" + b;
    }

    public static void main(String[] args) {
        Check1 b2 = MethodReference::sum;
        b2.add(100, 140);


    }


}
