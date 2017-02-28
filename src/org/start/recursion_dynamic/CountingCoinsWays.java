package org.start.recursion_dynamic;

public class CountingCoinsWays {

    public static void main(String[] args) {
        CountingCoinsWays countingCoinsWays = new CountingCoinsWays();
        int result = countingCoinsWays.countWays(10, new int[]{2, 3, 4});
        int result1 = countingCoinsWays.countWays(10, new int[]{1, 2, 3});

        System.out.println("Result is: " + result);
        System.out.println("Result1 is: " + result1);

    }

    public int countWays(int targetSum, int[] coins) {
        int[] table = new int[targetSum + 1];
        table[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j < table.length; j++) {
                table[j] = Math.max((table[j] + table[j - coin]), table[j]);
            }
        }

        return table[targetSum];

    }
}
