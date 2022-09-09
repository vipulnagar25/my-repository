package com.problem;

import java.util.Arrays;

public class RoationFiboSubtring {
    public static void rightRotation(int array[]) {
        int length = array.length - 1;
        int i = 0;
        int j = length;
        while (length > 0) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            length--;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fibonacci(int n) {
        System.out.println(n);
        int i = 0;
        int j = 1;
        System.out.print(i + " ");
        System.out.print(j + " ");
        for (int k = 0; k < n; k++) {
            int m = i + j;
            System.out.print(m + " ");
            i = j;
            j = m;

        }

    }

    public static void substring(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.print(str.substring(i, j) + " ");
            }
        }

    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        //System.out.println(Arrays.toString(array));
        //   rightRotation(array);
        fibonacci(6);
        System.out.println();
        // substring("abcd");

    }
}
