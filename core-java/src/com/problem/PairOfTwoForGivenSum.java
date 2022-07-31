package com.problem;

import java.util.Arrays;
import java.util.HashSet;

public class PairOfTwoForGivenSum {
    public static void ByBf(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.print(array[i] + ":::" + array[j] + "   ");
                }
            }
        }
    }

    public static void BySort(int[] array, int sum) {
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[i] + array[j] > sum) {
                j--;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else {
                System.out.print(array[i] + ":::" + array[j] + "   ");
                i++;
                j--;
            }

        }
    }

    public static void ByHash(int[] array, int sum) {
        HashSet<Integer> has = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (has.contains(sum - array[i])) {
                System.out.print(array[i] + ":::" + (sum - array[i]) + "   ");
            } else {
                has.add(array[i]);
            }
        }

    }


    public static void main(String[] args) {
        int sum = 11;
        int[] array = {5, 8, 3, 4, 2, 6, 10, 7, 1, 9 ,24};
        ByBf(array, 11);
        System.out.println();
        BySort(array, 11);
        System.out.println();
        ByHash(array, 11);


    }

}
