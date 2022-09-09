package com.problem;


//Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
//        Input  : arr[] = {100, 200, 300, 400}, k = 2
//        Output : 700
//        Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
//        Output : 39
//

public class MaximumSumInSubArrayOfSizek {

    // Returns .
    public static int maxSum(int arr[], int n, int k)
    {
        // k must be smaller than n
        if (n < k)
        {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int curr_sum = res;
        for (int i=k; i<n; i++)
        {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }

        return res;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }
}