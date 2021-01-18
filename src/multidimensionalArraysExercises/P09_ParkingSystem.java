package multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[][] parking = new boolean[dimensions[0]][dimensions[1]];

        String line = scan.nextLine();

        while (!"stop".equals(line)) {

            int[] data = Arrays.stream(line
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int entryRow = data[0];
            int destinationRow = data[1];
            int destinationCol = data[2];

            int distance = calculateDistance(parking, entryRow, destinationRow, destinationCol);

            if (distance == 1) {
                System.out.printf("Row %d full%n", destinationRow);
            } else {
                System.out.println(distance);
            }
            line = scan.nextLine();

        }
    }

    private static int calculateDistance(boolean[][] parking, int entryRow, int destinationRow, int destinationCol) {

        int distanceTraveled = 1;

        if (!parking[destinationRow][destinationCol]) {

            if (destinationRow > entryRow) {

                distanceTraveled += destinationRow - entryRow;

            } else if (destinationRow < entryRow) {

                distanceTraveled += entryRow - destinationRow;

            }

            distanceTraveled += destinationCol;
            parking[destinationRow][destinationCol] = true;
        } else {

            boolean hasFreeSpot = false;
            for (int i = 1; i < parking[destinationRow].length; i++) {

                if (!parking[destinationRow][i]) {
                    hasFreeSpot = true;
                    break;
                }
            }

            if (hasFreeSpot) {

                int rightFromInitialDistance = 0;
                boolean foundRightFreeSpot = false;
                int leftFromInitialDistance = 0;
                boolean foundLeftFreeSpot = false;

                for (int i = destinationCol + 1; i < parking[destinationRow].length; i++) {

                    rightFromInitialDistance++;
                    if (!parking[destinationRow][i]) {
                        foundRightFreeSpot = true;
                        break;
                    }
                }

                for (int i = destinationCol - 1; i > 0; i--) {

                    leftFromInitialDistance++;
                    if (!parking[destinationRow][i]) {
                        foundLeftFreeSpot = true;
                        break;
                    }
                }

                if (foundLeftFreeSpot && !foundRightFreeSpot) {

                    destinationCol -= leftFromInitialDistance;

                } else if (foundRightFreeSpot && !foundLeftFreeSpot) {

                    destinationCol += rightFromInitialDistance;

                } else if (leftFromInitialDistance <= rightFromInitialDistance) {

                    destinationCol -= leftFromInitialDistance;
                } else {

                    destinationCol += rightFromInitialDistance;
                }


                if (destinationRow > entryRow) {

                    distanceTraveled += destinationRow - entryRow;

                } else if (destinationRow < entryRow) {

                    distanceTraveled += entryRow - destinationRow;

                }

                distanceTraveled += destinationCol;
                parking[destinationRow][destinationCol] = true;

            }
        }

        return distanceTraveled;
    }
}
