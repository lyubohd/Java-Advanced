package javaAdvanced.genericsExercises.p03GenericSwapMethodString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String value = scan.nextLine();
            box.addValue(value);
        }
        int[] indexes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int indexOne = indexes[0];
        int indexTwo = indexes[1];
        box.swap(indexOne, indexTwo);
        System.out.println(box);
    }
}
