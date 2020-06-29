package com.dynamic.fibonacci;

public class FibonacciByBasicApproach {

	public static void fibonacciSeries(int value) {
		int v1 = 0;
		int v2 = 1;
		System.out.print(v1 + " " + v2);
		for (int i = 2; i < value; i++) {
			int v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
			System.out.print(" " + v3);
		}

	}

	public static int fibonacciSeriesByRecursion(int value) {
		if (value == 0) {
			return 0;
		}
		if (value == 1) {
			return 1;
		}

		return fibonacciSeriesByRecursion(value - 1) + fibonacciSeriesByRecursion(value - 2);

	}

	public static int fibonacciSeriesByDynamic(int value) {
		int[] temp = new int[value + 1];
		temp[0] = 0;
		temp[1] = 1;
		for (int i = 2; i <= value; i++) {
			temp[i] = temp[i - 1] + temp[i - 2];
		}
		return temp[value];
	}

	public static void main(String[] args) {
		fibonacciSeries(2);
		System.out.println();
		// System.out.println(fibonacciSeriesByRecursion(3));
		System.out.println(fibonacciSeriesByDynamic(2));
	}
}
