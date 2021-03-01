package javaAdvanced.workshop;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] sortedArray = mergeSort(Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray());
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int halfIndex = array.length / 2;
        int[] firstPartition = Arrays.copyOfRange(array, 0, halfIndex);
        int[] secondPartition = Arrays.copyOfRange(array, halfIndex, array.length);

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);
        return mergeTwoSortedArrays(firstPartition, secondPartition);
    }

    private static int[] mergeTwoSortedArrays(int[] firstPartition, int[] secondPartition) {
        int[] sorted = new int[firstPartition.length + secondPartition.length];

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstPartition.length && secondIndex < secondPartition.length) {
            if (firstPartition[firstIndex] < secondPartition[secondIndex]) {
                sorted[firstIndex + secondIndex] = firstPartition[firstIndex];
                firstIndex++;
            } else {
                sorted[firstIndex + secondIndex] = secondPartition[secondIndex];
                secondIndex++;
            }
        }

        while (firstIndex < firstPartition.length) {
            sorted[firstIndex + secondIndex] = firstPartition[firstIndex];
            firstIndex++;
        }

        while (secondIndex < secondPartition.length) {
            sorted[firstIndex + secondIndex] = secondPartition[secondIndex];
            secondIndex++;
        }

        return sorted;
    }
}
