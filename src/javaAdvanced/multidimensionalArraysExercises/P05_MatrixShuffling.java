package javaAdvanced.multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rowSize = input[0];
        int colSize = input[1];
        String[][] arr = new String[rowSize][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextLine().split("\\s+");
        }

        String pattern = "^swap (\\d+) (\\d+) (\\d+) (\\d+)$"; // Regex is used because there is a test with invalid number
        Pattern patternCompile = Pattern.compile(pattern);
        String cmd = scan.nextLine();
        while (!"END".equals(cmd)) {
            boolean isValid = true;
            Matcher matcher = patternCompile.matcher(cmd);
            if (matcher.matches()) {
                int row1 = Integer.parseInt(matcher.group(1));
                int col1 = Integer.parseInt(matcher.group(2));
                int row2 = Integer.parseInt(matcher.group(3));
                int col2 = Integer.parseInt(matcher.group(4));
                boolean isInArray = row1 >= 0 && row1 < rowSize && row2 >= 0 && row2 < rowSize
                        && col1 >= 0 && col1 < colSize && col2 >= 0 && col2 < colSize;
                if (isInArray) {
                    String temp = arr[row1][col1];
                    arr[row1][col1] = arr[row2][col2];
                    arr[row2][col2] = temp;
                    printArray(arr);
                } else {
                    isValid = false;
                }

            } else {
                isValid = false;
            }
            if (!isValid) {
                System.out.println("Invalid input!");
            }
            cmd = scan.nextLine();
        }
    }

    private static void printArray(String[][] arr) {
        for (String[] row : arr) {
            for (String element : row) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
    }
}