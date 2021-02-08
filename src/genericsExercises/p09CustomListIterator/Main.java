package genericsExercises.p09CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        CustomList<String> customList = new CustomList<>();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add": {
                    String element = tokens[1];
                    customList.add(element);
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                }
                case "Contains": {
                    String element = tokens[1];
                    System.out.println(customList.contains(element));
                    break;
                }
                case "Swap": {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                }
                case "Greater": {
                    String element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                }
                case "Min": {
                    System.out.println(customList.getMin());
                    break;
                }
                case "Max": {
                    System.out.println(customList.getMax());
                    break;
                }
                case "Print": {
                    for (String string : customList) {
                        System.out.println(string);
                    }
                    break;
                }
                case "Sort": {
                    Sorter.sort(customList);
                    break;
                }
            }
            input = scan.nextLine();
        }
    }
}
