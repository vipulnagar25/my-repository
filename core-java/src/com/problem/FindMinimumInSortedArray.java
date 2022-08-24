package com.problem;

public class FindMinimumInSortedArray {
    public static void findMinElement(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        if (start == end) {
            System.out.println(array[start]);
            return;
        }
        while (start < end) {
            mid = (start + end) / 2;
            if (array[mid] > array[end]) {
                start = mid + 1;
            }
            if (array[mid] < array[end]) {
                end = mid;
            }
        }
        System.out.println(array[start]);

    }


    public static void main(String[] args) {
        System.out.println("vipul");
        int[] array = {3, 4, 5, 1, 2};
        //int[] array = {1, 2, 3, 4, 5};
        findMinElement(array);
    }
}
