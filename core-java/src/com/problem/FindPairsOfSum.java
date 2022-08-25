package com.problem;

import java.util.HashMap;
import java.util.Map;

public class FindPairsOfSum {
    static int findSomeOfTwoArray(int[] arr, int sum) {
        int n=arr.length-1;
            HashMap<Integer, Integer> hm = new HashMap<>();

            // Store counts of all elements in map hm
            for (int i = 0; i < n; i++) {

                // initializing value to 0, if key not found
                if (!hm.containsKey(arr[i]))
                    hm.put(arr[i], 0);

                hm.put(arr[i], hm.get(arr[i]) + 1);
            }
            int twice_count = 0;

            // iterate through each element and increment the
            // count (Notice that every pair is counted twice)
            for (int i = 0; i < n; i++) {
                if (hm.get(sum - arr[i]) != null)
                    twice_count += hm.get(sum - arr[i]);

                // if (arr[i], arr[i]) pair satisfies the
                // condition, then we need to ensure that the
                // count is decreased by one such that the
                // (arr[i], arr[i]) pair is not considered
                if (sum - arr[i] == arr[i])
                    twice_count--;
            }

            // return the half of twice_count
            return twice_count / 2;
        }

    public static void main(String[] args) {
        int[] array = {1,9,6,4,6};
        int sum = 10;
        System.out.println( findSomeOfTwoArray(array, sum)+1);

    }
}
