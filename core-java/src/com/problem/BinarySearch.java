package com.problem;

public class BinarySearch {

    public static int getIndexByBinarySearch(int[] sortedArray, int key) {

        int start = 0;
        int last = sortedArray.length - 1;
        int result = -1;
        while (start <= last) {
            int mid = (last + start) / 2;
            if (sortedArray[mid] == key) {
                return mid;
            } else if (sortedArray[mid] < key) {
                start = mid + 1;
            } else if (sortedArray[mid] > key) {
                last = mid - 1;
            }


        }

        return result;
    }


    public static void main(String[] args) {
        int sortedArray[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(getIndexByBinarySearch(sortedArray, 4));
    }
}
