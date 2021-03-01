package javaAdvanced.genericsExercises.p11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        String address = tokens[2];
        String city = tokens[3];
        Threeuple<String, String, String> personDetails = new Threeuple<>(name, address, city);
        System.out.println(personDetails);

        tokens = scan.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        boolean isDrunk = "drunk".equals(tokens[2]);
        Threeuple<String, Integer, Boolean> personBeer = new Threeuple<>(name, liters, isDrunk);
        System.out.println(personBeer);

        tokens = scan.nextLine().split("\\s+");
        String customerName = tokens[0];
        double amount = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Threeuple<String, Double, String> numbers = new Threeuple<>(customerName, amount,bankName);
        System.out.println(numbers);
    }
}
