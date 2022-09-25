package com.java8;

import java.util.Arrays;

public class Reduce {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        // 1st argument, init value = 0
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);

        System.out.println("sum : " + sum);
        int sum1 = Arrays.stream(numbers).sum();
        System.out.println(sum1);
    }
}
