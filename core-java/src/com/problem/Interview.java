package com.problem;

import java.util.Arrays;

public class Interview {
    public static int highestSum(int N, int[] A, int[] B) {
        int[] dp = new int[N + 1];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            dp[A[i]]++;
            dp[B[i]]++;

        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        for (int j = dp.length - 1; j > 0; j--) {

            sum += dp[j] * j;
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] A = {2, 2, 1, 2};
        int[] B = {1, 3, 4, 4};
        int N = 5;
        highestSum(N, A, B);

    }
}
