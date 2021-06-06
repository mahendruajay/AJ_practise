package pattern_based.recursion.ik.live.session_prac1.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of n integers print all subsets whose sum is equal to k
 */
public class SubsetSum {

    public static void main(String[] args) {
        int[] input = {3, -3, -3};
        SubsetSum subsetSum = new SubsetSum();
        List<List<Integer>> results = subsetSum.subsetSum(input, -3);

        System.out.println("Results: " + results);
    }

    public List<List<Integer>> subsetSum(int[] input, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        subsetSumHelper(input, new ArrayList<>(), 0, targetSum, 0, results);
        return results;
    }

    public void subsetSumHelper(int[] input, List<Integer> slate, int idx, int targetSum, int runningSum, List<List<Integer>> results) {
        // base case
        if (runningSum == targetSum) {
            results.add(List.copyOf(slate));
            return;
        } else if (idx == input.length) {
            return;
        } else { // recurse

            // exclude
            subsetSumHelper(input, slate, idx + 1, targetSum, runningSum, results);

            // include
            slate.add(input[idx]);
            subsetSumHelper(input, slate, idx + 1, targetSum, input[idx] + runningSum, results);
            slate.remove(slate.size() - 1);

        }

    }
}
