package com.problem;

import java.util.Arrays;

public class RotateArrayKElement {
    public static int[] rotateOptimized(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k = k % n;
        }
        System.out.println(k + "::" + n);
        System.out.println("after first step");
        nums = reverse(nums, 0, n - 1);
        System.out.println("after second step");
        nums = reverse(nums, 0, k - 1);
        System.out.println("after third step");
        nums = reverse(nums, k, n - 1);


        return nums;
    }

    public static int[] reverse(int[] nums, int start, int end) {

        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(rotateOptimized(array, 3)));
    }
}
