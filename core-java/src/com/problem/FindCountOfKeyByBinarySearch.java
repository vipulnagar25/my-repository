package com.problem;

public class FindCountOfKeyByBinarySearch {
    public static int getIndexByBinarySearch(int[] sortedArray, int key, boolean isFirst) {
        int start = 0;
        int result = -1;
        int last = sortedArray.length;
        while (start < last) {
            int mid = (last + start) / 2;
            if (sortedArray[mid] == key) {
                result = mid;
                if (isFirst) {
                    last = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (sortedArray[mid] < key) {
                start = mid + 1;
            } else if (sortedArray[mid] > key) {
                last = mid - 1;
            }
        }


        return result;
    }


    public static void main(String[] args) {
        int sortedArray[] = {1, 2, 2, 2, 5, 6, 7};
//        System.out.println(getIndexByBinarySearch(sortedArray, 2, true));
//        System.out.println(getIndexByBinarySearch(sortedArray, 2, false));
        System.out.println(getIndexByBinarySearch(sortedArray, 2, false) - getIndexByBinarySearch(sortedArray, 2, true) + 1);

    }
}
