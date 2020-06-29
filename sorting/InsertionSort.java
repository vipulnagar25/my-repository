package com.sorting;

public class InsertionSort {

	public static int[] insertSort(int[] array) {
		int length = array.length;
		for (int i = 1; i < length; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		int array[] = { 1, 2, -3, 4, -5, 6, 7, 8 };
		int array1[] = insertSort(array);
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i]);
			if (array1.length - 1 != i)
				System.out.print("-->");
		}

	}
}
