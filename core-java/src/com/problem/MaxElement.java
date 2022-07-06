package com.problem;

import java.util.Arrays;

public class MaxElement {
    public static void findingMax(int[] array) {
        System.out.println(Arrays.toString(array));
        int max = array[0], secondMax = array[0];
        for(int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                secondMax = max;
                max = array[i];
            }
            if(secondMax < array[i] && max != array[i]) {
                secondMax = array[i];
            }

        }
        System.out.println(max);
        System.out.println(secondMax);


    }

    public static void main(String[] args) {
        int[] array = {2, 4, 5, 11, 11, 9,0,12,29,27};
        findingMax(array);
    }
}
