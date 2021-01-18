package multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        String[][] matrix = new String[input[0]][input[1]];
        fillMatrix(matrix);
        Arrays.stream(matrix).forEach(r -> {
            Arrays.stream(r).forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
    }

    private static void fillMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.format("%c%c%c", 97 + i, 97 + i + j, 97 + i);
            }
        }
    }
}