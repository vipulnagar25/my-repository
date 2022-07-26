package com.problem;

public class SpecialEntryInArray {
    public static int countSpecialEntryInArray(int array[]) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            for (int j = 0; j < (val / 2) + 1; j++) {
                if (j + reverse(j) == val) {
                    count++;
                    break;
                }
            }
            System.out.println(count + "check");
        }
        return count;

    }

    public static int reverse(int i) {
        StringBuilder sb = new StringBuilder(i + "");
        int sys = Integer.parseInt(sb.reverse().toString());
        return sys;
    }

    public static void main(String[] args) {
        int array[] = {22, 121};
        System.out.println(countSpecialEntryInArray(array));
    }
}
