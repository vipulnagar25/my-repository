package com.matrix;

import java.util.PriorityQueue;

public class Matrix {
    static int transposeMatrix[][] = new int[4][4];

    public static void printMatrix(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void transposeOfMatrix(int matrix[][]) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                transposeMatrix[col][row] = matrix[row][col];
            }
        }
    }

    public static void main(String[] args) {
        int array[][] = new int[4][4];
        int value = 10;
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                array[row][col] = value;
                value++;
            }
        }
       // printMatrix(array);
       // transposeOfMatrix(array);
        System.out.println("=============");
        //printMatrix(transposeMatrix);

        PriorityQueue ss=new PriorityQueue();
        ss.add(23);ss.add(44);
        ss.offer(22);
        ss.offer(34);
        ss.add(05);
        ss.add(11);
        System.out.println(ss);


    }
}
