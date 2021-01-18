package multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11_TheMatrix {
    private static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] matrixDim = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        matrix = new char[matrixDim[0]][matrixDim[1]];
        for (int i = 0; i < matrixDim[0]; i++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int j = 0; j < matrixDim[1]; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }

        char fillChar = scan.nextLine().charAt(0);
        int[] startCoord = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        char startChar = matrix[startCoord[0]][startCoord[1]];
        matrix[startCoord[0]][startCoord[1]] = fillChar;
        fillMatrix(startCoord[0], startCoord[1], startChar, fillChar);

        for (char[] row : matrix) {
            for (char symbol : row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int row, int col, char startChar, char fillChar) {
        if (row + 1 < matrix.length && matrix[row + 1][col] == startChar) {
            matrix[row + 1][col] = fillChar;
            fillMatrix(row + 1, col, startChar, fillChar);
        }

        if (row - 1 >= 0 && matrix[row - 1][col] == startChar) {
            matrix[row - 1][col] = fillChar;
            fillMatrix(row - 1, col, startChar, fillChar);
        }

        if (col + 1 < matrix[row].length && matrix[row][col + 1] == startChar) {
            matrix[row][col + 1] = fillChar;
            fillMatrix(row, col + 1, startChar, fillChar);
        }

        if (col - 1 >= 0 && matrix[row][col - 1] == startChar) {
            matrix[row][col - 1] = fillChar;
            fillMatrix(row, col - 1, startChar, fillChar);
        }
    }
}
