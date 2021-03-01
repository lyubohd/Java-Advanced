package javaAdvanced.multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P10_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] size = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            board[i] = scan.nextLine().toCharArray();
        }
        int[] playersStart = new int[2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'P') {
                    playersStart[0] = i;
                    playersStart[1] = j;
                }
            }
        }
        char[] moves = scan.nextLine().toCharArray();
        boolean isAlive = true;
        boolean inTheLiar = true;
        int currentMove = 0;
        while (isAlive && inTheLiar) {
            char move = moves[currentMove];
            int currentPlayerRow = playersStart[0];
            int currentPlayerCol = playersStart[1];
            char[][] newBoard = new char[rows][cols];
            board[playersStart[0]][playersStart[1]] = '.';
            newBoard[playersStart[0]][playersStart[1]] = '.';
            switch (move) {
                case 'U':
                    currentPlayerRow--;
                    if (currentPlayerRow < 0) {
                        inTheLiar = false;
                    } else {
                        if (board[currentPlayerRow][currentPlayerCol] == 'B') {
                            isAlive = false;
                            playersStart[0] = currentPlayerRow;
                        } else {
                            playersStart[0] = currentPlayerRow;
                            newBoard[playersStart[0]][playersStart[1]] = 'P';
                        }
                    }
                    break;
                case 'D':
                    currentPlayerRow++;
                    if (currentPlayerRow >= rows) {
                        inTheLiar = false;
                    } else {
                        if (board[currentPlayerRow][currentPlayerCol] == 'B') {
                            isAlive = false;
                            playersStart[0] = currentPlayerRow;
                        } else {
                            playersStart[0] = currentPlayerRow;
                            newBoard[playersStart[0]][playersStart[1]] = 'P';
                        }
                    }
                    break;
                case 'L':
                    currentPlayerCol--;
                    if (currentPlayerCol < 0) {
                        inTheLiar = false;
                    } else {
                        if (board[currentPlayerRow][currentPlayerCol] == 'B') {
                            isAlive = false;
                            playersStart[1] = currentPlayerCol;
                        } else {
                            playersStart[1] = currentPlayerCol;
                            newBoard[playersStart[0]][playersStart[1]] = 'P';
                        }
                    }
                    break;
                case 'R':
                    currentPlayerCol++;
                    if (currentPlayerCol >= board[0].length) {
                        inTheLiar = false;
                    } else {
                        if (board[currentPlayerRow][currentPlayerCol] == 'B') {
                            isAlive = false;
                            playersStart[1] = currentPlayerCol;
                        } else {
                            playersStart[1] = currentPlayerCol;
                            newBoard[playersStart[0]][playersStart[1]] = 'P';
                        }
                    }
                    break;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'B') {
                        newBoard[i][j] = 'B';
                        if (i - 1 >= 0) {
                            if (newBoard[i - 1][j] == 'P') {
                                isAlive = false;
                            }
                            newBoard[i - 1][j] = 'B';
                        }
                        if (i + 1 < board.length) {
                            if (newBoard[i + 1][j] == 'P') {
                                isAlive = false;
                            }
                            newBoard[i + 1][j] = 'B';
                        }
                        if (j - 1 >= 0) {
                            if (newBoard[i][j - 1] == 'P') {
                                isAlive = false;
                            }
                            newBoard[i][j - 1] = 'B';
                        }
                        if (j + 1 < board[0].length) {
                            if (newBoard[i][j + 1] == 'P') {
                                isAlive = false;
                            }
                            newBoard[i][j + 1] = 'B';
                        }
                    } else if (newBoard[i][j] != 'P' && newBoard[i][j] != 'B') {
                        newBoard[i][j] = '.';
                    }
                }
            }
            currentMove++;
            board = newBoard;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        if (inTheLiar) {
            System.out.printf("dead: %d %d", playersStart[0], playersStart[1]);
        } else {
            System.out.printf("won: %d %d", playersStart[0], playersStart[1]);
        }
    }
}
