package javaAdvanced.multidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = 0;
        String input = scanner.nextLine();
        String regex = "(?<=\\()\\d+(?=\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group());
        }
        if (degrees >= 360) {
            degrees = degrees % 360;
        }
        String line = scanner.nextLine();
        List<String> words = new ArrayList<>();
        int maxLength = 0;
        int rows = 0;
        while (!line.equals("END")) {
            int currentLength = line.length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            words.add(line);
            rows++;
            line = scanner.nextLine();
        }
        char[][] matrix = new char[rows][maxLength];
        for (int i = 0; i < words.size(); i++) {
            StringBuilder word = new StringBuilder(words.get(i));
            while (word.length() < maxLength) {
                word.append(" ");
            }
            words.set(i, word.toString());
        }
        for (int row = 0; row < rows; row++) {
            matrix[row] = words.get(row).toCharArray();
        }
        char[][] newMAtrix = rotateMatrix(matrix, degrees);
        printMatrix(newMAtrix);

    }

    private static char[][] rotateMatrix(char[][] matrix, int degrees) {
        switch (degrees) {
            case 0:
                return matrix;
            case 90:
                char[][] newMatrix = new char[matrix[0].length][matrix.length];
                int currentCol = 0;
                for (int rows = 0; rows < newMatrix.length; rows++) {
                    for (int cols = 0; cols < newMatrix[0].length; cols++) {
                        newMatrix[rows][cols] = matrix[matrix.length - 1 - cols][currentCol];
                    }
                    currentCol++;
                }
                return newMatrix;
            case 180:
                newMatrix = new char[matrix.length][matrix[0].length];
                int currRow = matrix.length - 1;
                for (int rows = 0; rows < newMatrix.length; rows++) {
                    for (int cols = 0; cols < newMatrix[0].length; cols++) {
                        newMatrix[rows][cols] = matrix[currRow][matrix[0].length - 1 - cols];
                    }
                    currRow--;
                }
                return newMatrix;
            case 270:
                newMatrix = new char[matrix[0].length][matrix.length];
                currentCol = matrix[0].length - 1;
                for (int rows = 0; rows < newMatrix.length; rows++) {
                    for (int cols = 0; cols < newMatrix[0].length; cols++) {
                        newMatrix[rows][cols] = matrix[cols][currentCol];
                    }
                    currentCol--;
                }
                return newMatrix;

        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(row[col]);
            }
            System.out.println();
        }
    }
}
