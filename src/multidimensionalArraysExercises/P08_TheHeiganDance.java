package multidimensionalArraysExercises;

import java.util.Scanner;

public class P08_TheHeiganDance {

    private static int[][] chamber = new int[15][15];
    private static int playerHP = 18500;
    private static int playerRow = 7;
    private static int playerCol = 7;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double playerDmg = Double.parseDouble(scan.nextLine());
        double bossHP = 3000000;
        int previousColHit = -100;
        int previousRowHit = -100;
        String previousSpell = "";
        String spell = "";
        while (playerHP > 0 && bossHP > 0) {
            bossHP -= playerDmg;

            if (bossHP <= 0) {
                if (chamber[playerRow][playerCol] > 0) {
                    playerHP -= 3500;
                }
                continue;
            }

            String[] cmd = scan.nextLine().split("\\s+");
            spell = cmd[0];
            int rowHit = Integer.parseInt(cmd[1]);
            int colHit = Integer.parseInt(cmd[2]);


            if ("Cloud".equals(spell)) {
                if (chamber[playerRow][playerCol] > 0) {
                    playerHP -= 3500;
                    if (playerHP < 0) {
                        spell = previousSpell;
                        continue;
                    }
                }

                if ("Cloud".equals(previousSpell)) {
                    spellAOE(previousRowHit, previousColHit, -1);
                }

                spellAOE(rowHit, colHit, 2);
                if (chamber[playerRow][playerCol] > 0) {
                    movePlayer();
                }


                if (chamber[playerRow][playerCol] > 0) {
                    playerHP -= 3500;
                }

                spellAOE(rowHit, colHit, -1);

            } else if ("Eruption".equals(spell)) {

                if (chamber[playerRow][playerCol] > 0) {
                    playerHP -= 3500;
                    if (playerHP < 0) {
                        spell = previousSpell;
                        continue;
                    }
                }

                if ("Cloud".equals(previousSpell)) {
                    spellAOE(previousRowHit, previousColHit, -1);
                }

                spellAOE(rowHit, colHit, 1);
                if (chamber[playerRow][playerCol] > 0) {
                    movePlayer();
                }

                if (chamber[playerRow][playerCol] > 0) {
                    playerHP -= 6000;
                }

                spellAOE(rowHit, colHit, -1);
            }

            previousRowHit = rowHit;
            previousColHit = colHit;
            previousSpell = spell;
        }

        spell = "Cloud".equals(spell) ? "Plague Cloud" : spell;

        if (bossHP <= 0) {
            System.out.printf("Heigan: Defeated!%n");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHP);
        }

        if (playerHP <= 0) {
            System.out.printf("Player: Killed by %s%n", spell);
        } else {
            System.out.printf("Player: %d%n", playerHP);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }

    private static boolean isInChamber(int row, int col) {
        return row >= 0 && row < chamber.length && col >= 0 && col < chamber[row].length;
    }

    private static void spellAOE(int rowHit, int colHit, int duration) {
        for (int row = rowHit - 1; row <= rowHit + 1; row++) {
            for (int col = colHit - 1; col <= colHit + 1; col++) {
                if (isInChamber(row, col)) {
                    chamber[row][col] += duration;
                }
            }
        }
    }

    private static void movePlayer() {
        if (playerRow - 1 >= 0 && chamber[playerRow - 1][playerCol] == 0) {
            playerRow--;
        } else if (playerCol + 1 < chamber[playerRow].length && chamber[playerRow][playerCol + 1] == 0) {
            playerCol++;
        } else if (playerRow + 1 < chamber.length && chamber[playerRow + 1][playerCol] == 0) {
            playerRow++;
        } else if (playerCol - 1 >= 0 && chamber[playerRow][playerCol - 1] == 0) {
            playerCol--;
        }

    }
}
