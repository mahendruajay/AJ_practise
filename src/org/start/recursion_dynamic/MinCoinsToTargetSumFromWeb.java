package org.start.recursion_dynamic;

import java.util.Arrays;

public class MinCoinsToTargetSumFromWeb {


    int findMinCoins(int sum, int coins[]) {
        int[] lookup = new int[sum + 1];
        int[] biggestDenomAtSumK = new int[sum + 1];


        Arrays.fill(lookup, Integer.MAX_VALUE - 1);
        Arrays.fill(biggestDenomAtSumK, -1);

        lookup[0] = 0;


        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                int minCoinsWithNewCoin = lookup[j - coin] + 1;
                if (minCoinsWithNewCoin < lookup[j]) {
                    lookup[j] = minCoinsWithNewCoin;
                    biggestDenomAtSumK[j] = coin;
                }
            }
        }

        int total = sum;
        if (biggestDenomAtSumK[total] == -1) {
            return -1;
        }
        System.out.print("Coins are: ");
        while (total > 0) {
            System.out.print(biggestDenomAtSumK[total] + " ");
            total = total - biggestDenomAtSumK[total];
        }
        System.out.println();

        return lookup[sum];
    }


    public static void main(String[] args) {
        MinCoinsToTargetSumFromWeb minCoinsToTargetSum = new MinCoinsToTargetSumFromWeb();
        int result1 = minCoinsToTargetSum.findMinCoins(10, new int[]{7, 2, 3, 6});
        int result2 = minCoinsToTargetSum.findMinCoins(11, new int[]{3, 1});
//        int result3 = minCoinsToTargetSum.findMinCoins(10, new int[]{1, 3, 5});
//        int result4 = minCoinsToTargetSum.findMinCoins(10, new int[]{1, 4, 7});

        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
//        System.out.println("Result 3: " + result3);
//        System.out.println("Result 4: " + result4);
    }
}
