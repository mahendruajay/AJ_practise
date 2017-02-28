package org.start.recursion_dynamic;

public class CountingCoinsFromWeb {


    public static void main(String[] args) {
        maxWays(11, new int[]{7, 2});
        maxWays(10, new int[]{1, 2, 3});
        maxWays(10, new int[]{1, 3, 5});
        maxWays(10, new int[]{1, 4, 7});
    }

    static void maxWays(int targetSum, int coins[]) {
        debugInput(targetSum, coins);
        // Lookup to store solutions for all sums from
        // 0 to targetSum.
        int sums[] = new int[targetSum + 1];

        // Used to indicate that a solution exists when
        // a coin equal to current sum is used.
        // i.e. sums[sumK-coin] should return 1 when sumK equals coin
        sums[0] = 1;

        // Pick all coins one by one and update the lookup 'sums'
        // to indicate the effect of introducing that coin
        for (int coin : coins) {
            // For sums less than current coin value, there would be
            // no effect of introducing this coin, hence we begin from
            // the sum atleast equal in value to current coin
            for (int j = coin; j <= targetSum; j++) {
                sums[j] = sums[j] + // current coin is not used
                        sums[j - coin]; // current coin is used
            }
            print(sums);
        }
        System.out.println("Maximum no of ways = " + sums[targetSum]);
    }

    /*********************
     * DEBUG FUNCTIONS
     **********************/
    private static void debugInput(int targetSum, int[] coins) {
        System.out.println("\n\nTargetSum = " + targetSum +
                ", Coins =" + arrayToString(coins));
        System.out.print(" ");
        for (int i = 0; i <= targetSum; i++)
            System.out.print(String.format("[%2d]", i) + " ");
        System.out.println();
    }

    private static void print(int[] s) {
        System.out.println(arrayToString(s));
    }

    private static String arrayToString(int[] sums) {
        String buf = "";
        for (int s : sums)
            buf += String.format("%4d", s) + " ";
        return buf;
    }
}

