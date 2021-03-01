package javaAdvanced.multidimensionalArraysExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.indexOf(')'))) % 360;

        input = scan.nextLine();
        ArrayDeque<String> inputQueue = new ArrayDeque<>();
        int maxLength = 0;
        while (!"END".equals(input)) {
            inputQueue.offer(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scan.nextLine();
        }

        char[][] charArr = new char[inputQueue.size()][maxLength];
        for (int i = 0; i < charArr.length; i++) {
            String row = inputQueue.poll();
            for (int j = 0; j < maxLength; j++) {
                if (row != null && j < row.length()) {
                    charArr[i][j] = row.charAt(j);
                } else {
                    charArr[i][j] = ' ';
                }
            }
        }

        if (degrees == 0) {
            rotationAt0(charArr);
        } else if (degrees == 90) {
            rotationAt90(charArr);
        } else if (degrees == 180) {
            rotationAt180(charArr);
        } else if (degrees == 270) {
            rotationAt270(charArr);
        }
    }

    private static void rotationAt0(char[][] charArr) {
        for (char[] row : charArr) {
            for (int col = 0; col < charArr[0].length; col++) {
                System.out.print(row[col]);
            }
            System.out.println();
        }
    }

    private static void rotationAt90(char[][] charArr) {
        for (int col = 0; col < charArr[0].length; col++) {
            for (int row = charArr.length - 1; row >= 0; row--) {
                System.out.print(charArr[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAt180(char[][] charArr) {
        for (int row = charArr.length - 1; row >= 0; row--) {
            for (int col = charArr[0].length - 1; col >= 0; col--) {
                System.out.print(charArr[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotationAt270(char[][] charArr) {
        for (int col = charArr[0].length - 1; col >= 0; col--) {
            for (char[] row : charArr) {
                System.out.print(row[col]);
            }
            System.out.println();
        }
    }
}