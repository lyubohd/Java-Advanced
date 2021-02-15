package workshop;

import java.util.Arrays;
import java.util.Scanner;

public class P06_BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int target = Integer.parseInt(scan.nextLine());

        int index = binarySearch(numbers, target, 0, numbers.length - 1);

        System.out.println(index);
    }

    private static int binarySearch(int[] numbers, int target, int start, int end) {
        while (end >= start) {
            int half = (start + end) / 2;
            if (numbers[half] < target) {
                start = half + 1;
            } else if (numbers[half] > target) {
                end = half - 1;
            } else {
                return half;
            }
        }

        return -1;
    }
}
