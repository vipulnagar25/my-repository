package com.problem;

public class PrimeNumber {

    public static boolean isPrimeNumber(int i) {
        if (i == 1 || i == 2) {
            return true;
        } else {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    return false;
                }
            }
            return false;
        }
    }

    static boolean isPrime(int n, int i) {

        // Base cases
        if (n <= 2)
            return (n == 2) ? true : false;
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;

        // Check for next divisor
        return isPrime(n, i + 1);
    }

    public static void main(String[] args) {

        System.out.println("This is prime number :: " + isPrimeNumber(9));
        System.out.println(isPrime(9, 2));
    }
}
