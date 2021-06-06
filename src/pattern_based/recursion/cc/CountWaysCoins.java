package pattern_based.recursion.cc;

/*
Given an infinite number of quarters, dimes, nickels and pennies, write code to
calculate the number of ways of representing n cents.

 */

import pattern_based.searching_sorting.practise_2021.iter1.CountingSort;
import playground.launch.C;

import java.util.HashMap;
import java.util.Map;

public class CountWaysCoins {

    public static void main(String[] args) {
        CountWaysCoins countWaysCoins = new CountWaysCoins();
        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println("Results: " + countWaysCoins.countWaysCoins(100, memo));
    }

    public int countWaysCoins(int cents, Map<Integer, Integer> memo) {
        return countWaysCoinsHelper(cents, 0, memo);
    }

    public int countWaysCoinsHelper(int cents, int idx, Map<Integer, Integer> memo) {
        if (idx > cents) {
            return 0;
        }
        if (idx == cents) {
            return 1;
        } else if (memo.containsKey(idx)) {
            return memo.get(idx);
        } else {
            int pennies = countWaysCoinsHelper(cents, idx + 1, memo);
            int nickles = countWaysCoinsHelper(cents, idx + 5, memo);
            int dimes = countWaysCoinsHelper(cents, idx + 10, memo);
            int quarters = countWaysCoinsHelper(cents, idx + 25, memo);
            memo.put(idx, pennies + nickles + dimes + quarters);
            return memo.get(idx);
        }
    }
}
