package com.problem;

public class PrimeNumber {

    public static boolean isPrimeNumber(int i) {
        if(i == 1 || i == 2) {
            return true;
        } else {
            for(int j = 2; j <= i / 2; j++) {
                if(i % j == 0) {
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println("This is prime number :: " + isPrimeNumber(9));
    }
}
