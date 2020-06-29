package com.rnd;

import java.util.Arrays;

public class ZeroAndOneSort {
    public static void replace1() {
        int count = 0;
        int array[] = {0, 1, 1, 1, 0, 0, 0, 0};
        System.out.println(Arrays.toString(array));
        for (int i : array) {
            if (i == 0) {
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (i < count) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void replace2() {
        int array[] = {0, 1, 1, 1, 0, 0, 1, 1};
        int start = 0;
        int end = array.length - 1;
        System.out.println(Arrays.toString(array));
        while (start < end) {
            if (array[end] == 1) {
                end--;
            }
            if (array[start] == 0) {
                start++;
            }
            if (array[start] == 1 && array[end] == 0) {
                array[start] = 0;
                array[end] = 1;
                start++;
                end--;
            }
        }
        System.out.println(Arrays.toString(array));

    }


    public static void main(String[] args) {
        replace2();
    }


}
