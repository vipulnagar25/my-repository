package com.search;

public class BinarySearch {
    public static int binarySearchByIteration(int array[], int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchByRecursion(int array[], int key, int low, int high) {

        int mid = low + high;


        return -1;
    }

    public static void main(String[] args) {

        int tempArray[] = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int result = binarySearchByIteration(tempArray, 10);
        if (result > -1) {
            System.out.println("found element is == " + tempArray[result]);
        } else {
            System.err.println("element not found");
        }

    }
}
