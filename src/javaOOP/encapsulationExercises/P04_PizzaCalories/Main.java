package javaOOP.encapsulationExercises.P04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaTokens = scan.nextLine().split("\\s+");
        String[] doughTokens = scan.nextLine().split("\\s+");

        Pizza pizza;
        try {
            int countOfToppings = Integer.parseInt(pizzaTokens[2]);
            pizza = new Pizza(pizzaTokens[1], countOfToppings);
            Dough dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);

            for (int i = 0; i < countOfToppings; i++) {
                String[] toppingTokens = scan.nextLine().split("\\s+");
                Topping topping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));

                pizza.addTopping(topping);
            }

        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
            return;
        }

        System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getOverallCalories()));
    }
}
