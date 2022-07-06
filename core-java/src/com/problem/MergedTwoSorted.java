package com.problem;

import java.util.Arrays;

public class MergedTwoSorted {
    public static void mergedTwoArray(int[] array1, int[] array2) {
        int l = 0;
        int a1 = 0;
        int a2 = 0;
        int[] newArray = new int[array1.length + array2.length];
        while(a1 < array1.length && a2 < array2.length) {
            if(array1[a1] == array2[a2]) {
                newArray[l++] = array1[a1];
                a1++;
                a2++;
            } else if(array1[a1] < array2[a2]) {
                newArray[l++] = array1[a1];
                a1++;
            } else if(array1[a1] > array2[a2]) {
                newArray[l++] = array2[a2];
                a2++;
            }
        }
        while(a1 < array1.length) {
            newArray[l++] = array1[a1++];
        }
        while(a2 < array2.length) {
            newArray[l++] = array2[a2++];
        }
        System.out.println(Arrays.toString(newArray) + "l::" + l);
    }


    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 6, 7, 8, 9};
        mergedTwoArray(array1, array2);
    }
}
