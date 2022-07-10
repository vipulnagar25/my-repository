package com.collection.search;

public class BinarySearch {
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            System.out.println("low::" + low + "high::" + high + "calculation::" + ((high - low) / 2));
            int mid = low + ((high - low) / 2);
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] < key) {
                low = mid + 1;
            }
            if (array[mid] > key) {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchByRecurrence(int[] array, int key, int low, int high) {
        int mid = low + ((high - low) / 2);
        if(high <low){
            return  -1;
        }
        if (array[mid] == key) {
            return mid;
        }

        if (array[mid] > key) {
            return binarySearchByRecurrence(array, key, low, mid - 1);
        } else {
            return binarySearchByRecurrence(array, key, mid + 1, high);
        }
    }


    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5};
        int element = 1;
        int findIndex = binarySearch(array, element);
        if (findIndex == -1) {
            System.out.println(element + "::" + "this is not found");
        } else {
            System.out.println(element + "::" + "this is found at index" + "::" + findIndex);
        }
        int findIndexByRecurrence =binarySearchByRecurrence(array, element, 0, array.length-1);;
        if (findIndexByRecurrence == -1) {
            System.out.println(element + "::" + "this is not found");
        } else {
            System.out.println(element + "::" + "this is found at index" + "::" + findIndex);
        }
    }
}
