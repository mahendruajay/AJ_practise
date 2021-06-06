package pattern_based.recursion.ik.live.session_prac1.backtracking;

/*
Given a number of dice to roll and a desired sum, print all combinations of dice values that add up to a given sum.
Each dice has 6 values = {1, 2, 3, 4, 5, 6}
Example:
Input: number of dice = 2, target sum = 7
Output: {1, 6), {2, 5}, {3, 4}, {4, 3}, {5, 2}, {6, 1}

 */

import java.util.ArrayList;
import java.util.List;

public class DiceRollSum {

    public static void main(String[] args) {
        DiceRollSum diceRollSum = new DiceRollSum();
        List<List<Integer>> results = diceRollSum.diceSum(3, 18);
        System.out.println("Results: " + results);
    }

    public List<List<Integer>> diceSum(int numDice, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        diceSumHelper(numDice, new ArrayList<>(), targetSum, 0, 0, results);
        return results;
    }

    public void diceSumHelper(int numDice, List<Integer> slate, int targetSum, int runningSum, int idx, List<List<Integer>> results) {
        // base case
        int remainingDice = numDice - idx;
        if (runningSum + (remainingDice * 6) < targetSum ||
                runningSum + (remainingDice * 1) > targetSum) {
            return;
        }
        if (runningSum > targetSum) {
            return;
        } else if (idx == numDice && runningSum == targetSum) {
            results.add(List.copyOf(slate));
            return;
        } else if (idx == numDice) {
            return;
        } else {
            for (int i = 1; i <= 6; i++) {

                slate.add(i);
                diceSumHelper(numDice, slate, targetSum, runningSum + i, idx + 1, results);
                slate.remove(slate.size() - 1);
            }

        }
    }
}
