package com.problem;

public class SumOfSubArray {
    public static void printSubArray(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int current_sum = 0;
                for (int k = i; k <= j; k++) {
                    current_sum = current_sum + array[k];
                    System.out.print(array[k] + " ");
                }
                if (current_sum == sum) {
                    System.out.print("sum hai");
                }
                System.out.println();
            }
        }
    }

    public static void find_subarray(int arr[], int required) {
        int N =arr.length;
        int sum;
        for (int i = 0; i < N; i++) {
            sum = arr[i];
            for (int j = i + 1; j <= N; j++) {
                if (sum == required) {
                    System.out.println(i+" between "+j);
                    return ;
                }
                if (sum > required || j == N)
                    break;
                sum = sum + arr[j];
            }
        }
        return ;
    }


    public static void main(String[] args) {
        int sum = 10;
        int[] array = {7,8,2,6,22,23};
        printSubArray(array, sum);
        //find_subarray(array,sum);
    }
}
