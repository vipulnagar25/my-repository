package com.problem;

public class FindMinMaxInArray {
    public static void minMax(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            } else if (min > array[i]) {
                min = array[i];
            }

        }
        System.out.println("Min = " + min + "::" + "Max " + max);

    }


    public static void main(String[] args) {
        int array[] = {1, 22, 3, 4, 5, 6, 0};
        minMax(array);
        System.out.println("nagar");
    }
}
