package com.dynamic.rodCutting;

public class RodCutting {
	static int rodCut(int[] array, int rodelength) {
		if (rodelength == 0) {
			return 0;
		}
		int i, q = -1;
		for (i = 1; i <= rodelength; i++) {
			q = Math.max(q, array[i] + rodCut(array, rodelength - i));
		//	System.out.println(q + "nagar"+i);
		}
		return q;
	}
	public static void main(String[] args) {
		int[] valuArray = {0,1,5,8,9,10};
		int j = rodCut(valuArray, 4);
		System.out.println(j);
	}
}
