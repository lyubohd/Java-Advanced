package javaAdvanced.multidimensionalArraysExercises;

import java.util.Scanner;

public class P01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String fillPattern = tokens[1];

        int[][] matrix = fillMatrix(n, fillPattern);
        printMatrix(matrix);
    }

    private static int[][] fillMatrix(int n, String fillPattern) {
        int[][] matrix = new int[n][n];
        if ("A".equals(fillPattern)) {
            fillPatternA(matrix);
        } else if ("B".equals(fillPattern)) {
            fillPatternB(matrix);
        }
        return matrix;
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = number++;
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[j][i] = number++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = number++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(String.format("%d ", element));
            }
            System.out.println();
        }
    }
}