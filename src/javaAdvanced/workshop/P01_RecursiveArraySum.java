package javaAdvanced.workshop;

import java.util.Arrays;
import java.util.Scanner;

public class P01_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sum(numbers, 0));
    }

    private static int sum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        return arr[index] + sum(arr, index + 1);
    }
}
