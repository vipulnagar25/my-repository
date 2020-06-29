package com.sorting;

public class SelectionSort {
	public static int[] selectionSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int array[] = { 8,5,3,9,3,5,1};
		int array1[] = selectionSort(array);
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i]);
			if (array1.length - 1 != i)
				System.out.print("-->");
		}
	}
}
