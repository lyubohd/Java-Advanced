package javaAdvanced.workshop;

import java.util.*;
import java.util.stream.Collectors;

public class P03_SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> chosenCoins = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;

        List<Integer> sortedCoins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        while (currentSum != targetSum && coinIndex < sortedCoins.size()) {
            int currentCoin = sortedCoins.get(coinIndex);

            int moneyLeft = targetSum - currentSum;
            int numberOfCoins = moneyLeft / currentCoin;

            if (currentSum + currentCoin <= targetSum) {
                chosenCoins.put(currentCoin, numberOfCoins);
                currentSum += currentCoin * numberOfCoins;
            }

            coinIndex++;
        }

        if (currentSum != targetSum) {
            throw new IllegalArgumentException();
        }
        return chosenCoins;
    }
}