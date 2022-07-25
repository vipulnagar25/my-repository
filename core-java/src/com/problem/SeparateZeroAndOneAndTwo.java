package com.problem;

import java.util.Arrays;

public class SeparateZeroAndOneAndTwo {
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void separateZeroAndOneAndTwo(int array[]) {
        System.out.println("print before sort " + Arrays.toString(array));
        int i = 0;
        int j = 0;
        int k = array.length - 1;

        while (i <= k) {
            if (array[i] == 0) {
                swap(array, i, j);
                i++;
                j++;
            } else if (array[i] == 1) {
                i++;
            } else if (array[i] == 2) {
                swap(array, i, k);
                k--;
            }

        }
        System.out.println("print after sort " + Arrays.toString(array));

    }


    public static void main(String[] args) {
        int[] array = {2, 0, 1, 2, 0, 1, 1};
        separateZeroAndOneAndTwo(array);
    }
}
