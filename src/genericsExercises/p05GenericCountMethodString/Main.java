package genericsExercises.p05GenericCountMethodString;

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

        String toCompare = scan.nextLine();
        System.out.println(box.countGreaterElements(toCompare));
    }
}
