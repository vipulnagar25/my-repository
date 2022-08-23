package com.problem;

import java.util.Arrays;

public class SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length, left = 0,
                right = n - 1;

        int result[] = new int[n];

        for (int index = n - 1; index >= 0; index--) {
            if (Math.abs(nums[left]) > nums[right]) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {-3, -3, 4, 5};
        sortedSquares(arr);
    }
}
