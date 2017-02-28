package org.start.recursion_dynamic;

import java.util.Arrays;

public class MinCoinsForTargetSum {

    public static void main(String[] args) {

        MinCoinsForTargetSum minCoinsForTargetSum = new MinCoinsForTargetSum();

        int result1 = minCoinsForTargetSum.minCoins(10, new int[]{2, 3, 4});
        System.out.println("Result is: " + result1);


    }

    public int minCoins(int targetSum, int[] coins) {

        int[] table = new int[targetSum + 1];
        int[] result = new int[targetSum + 1];

        Arrays.fill(table, Integer.MAX_VALUE - 1);
        Arrays.fill(result, -1);

        table[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j < table.length; j++) {
                int minCount = 1 + table[j - coin];
                if (minCount < table[j]) {
                    table[j] = minCount;
                    result[j] = coin;
                }
            }
        }
        int minCount = table[targetSum];

        System.out.print("Coins are :");
        while (targetSum > 0) {
            System.out.print(result[targetSum] + " ");
            targetSum = targetSum - result[targetSum];
        }
        System.out.println();

        return minCount;

    }


}
