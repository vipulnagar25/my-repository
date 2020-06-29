package com.sorting;

public class BubbleSort {

    // best case O(n)
// worst case O(n*n)
    public static int[] bubbleSort(int array[]) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            //		System.out.println(i);
            boolean alreadySorted = true;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    alreadySorted = false;
                }
            }
            if (alreadySorted) {
                break;
            }
        }
        return array;

    }

    public static void main(String[] args) {
        int array[] = {1, 2, -3, 4, -5, 6, 7, 8};
        int array1[] = bubbleSort(array);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]);
            if (array1.length - 1 != i)
                System.out.print("-->");
        }

    }
}
