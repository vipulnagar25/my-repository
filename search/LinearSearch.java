package com.search;

public class LinearSearch {
    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int tempArray[] = {0, 1, 2, 3, 4, 6, 9, 13, 4, 55, 33, 23, 35};
        int result = search(tempArray, 5);
        if (result > -1) {
            System.out.println("found element is ==" + tempArray[result]);
        } else {
            System.err.println("element not found");
        }


    }

}
