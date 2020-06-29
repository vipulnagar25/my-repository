package com.array;

import java.util.*;

public class Array {
    public static int findminimumValue(int array[]) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        return min;

    }

    //
    public static void reverseArray(int array[]) {

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }


        System.out.println(Arrays.toString(array));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("Two numbers not found");
    }


    public static void main(String[] args) {
        int array[] = {10, 12, 7, 5, 36};
        //System.out.println(Arrays.toString(array));
       // reverseArray(array);
		//System.out.println(Arrays.toString(array));
        Queue<String>ee=new LinkedList<>();
        ee.offer("www");
        System.out.println(ee.size());

        String s2=ee.poll();
        System.out.println(ee.size());


    }

}
