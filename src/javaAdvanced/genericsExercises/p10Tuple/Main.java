package javaAdvanced.genericsExercises.p10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        String address = tokens[2];
        Tuple<String, String> personDetails = new Tuple<>(name, address);
        System.out.println(personDetails);

        tokens = scan.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> personBeer = new Tuple<>(name, liters);
        System.out.println(personBeer);

        tokens = scan.nextLine().split("\\s+");
        int intNum = Integer.parseInt(tokens[0]);
        double floatNum = Double.parseDouble(tokens[1]);
        Tuple<Integer, Double> numbers = new Tuple<>(intNum, floatNum);
        System.out.println(numbers);
    }
}
