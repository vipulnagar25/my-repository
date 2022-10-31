package com.problem;

import java.util.Arrays;

public class EquilibriumIndex {
    public static void equilibrium(int arr[], int n) {
        int sum = 0; // initialize sum of whole array
        int leftSum = 0; // initialize leftsum
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
        }
        System.out.println(leftSum + "total");
        for (int i = 0; i < n; ++i) {
            sum -= arr[i]; // sum is now right sum for index i
            if (leftSum == sum)
                System.out.println(arr[i] + "test");
            leftSum += arr[i];
        }
    }

    // Driver code
    public static void main(String[] args) {

        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int arr_size = arr.length;
        System.out.println("First equilibrium index is ");
        equilibrium(arr, arr_size);

    }
}
