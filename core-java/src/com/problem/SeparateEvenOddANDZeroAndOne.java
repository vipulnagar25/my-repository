package com.problem;

import java.util.Arrays;

public class SeparateEvenOddANDZeroAndOne {
    public static void separateZeroAndOne(int[] array) {
        System.out.println(Arrays.toString(array));
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
            if(array[end] == 1) {
                end--;
            }
            if(array[start] == 0) {
                start++;
            }
            if(array[start] == 1 && array[end] == 0) {
                array[start] = 0;
                array[end] = 1;
                start++;
                end--;
            }
        }
        System.out.println(Arrays.toString(array));

    }

    public static void separateEvenOdd(int[] array) {
        System.out.println(Arrays.toString(array));
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
            if(array[end] % 2 != 0) {
                end--;
            }
            if(array[start] % 2 == 0) {
                start++;
            }
            if((array[start] % 2) != 0 && (array[end] % 2) == 0 && start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1};
        separateZeroAndOne(array);
        int[] array1 = {2, 4, 3, 5, 1, 6, 7, 8, 9, 10};
        separateEvenOdd(array1);
    }
}
