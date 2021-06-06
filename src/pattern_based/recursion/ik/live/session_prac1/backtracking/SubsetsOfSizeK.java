package pattern_based.recursion.ik.live.session_prac1.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given two numbers n and k, return/print all subsets of size k

Example:
Input: n = 4, k =2
Output: {
        1, 2
        1, 3
        1, 4
        2, 3
        2, 4
        3, 4}
 */
public class SubsetsOfSizeK {

    public static void main(String[] args) {
        SubsetsOfSizeK subsetsOfSizeK = new SubsetsOfSizeK();
        List<List<Integer>> results = subsetsOfSizeK.subsetsOfSizeK(4, 2);
        System.out.println("Results: " + results);
    }

    public List<List<Integer>> subsetsOfSizeK(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        subsetsOfSizeKHelper(n, new ArrayList<>(), 0, results, k);
        return results;
    }

    public void subsetsOfSizeKHelper(int n, List<Integer> slate, int idx, List<List<Integer>> results, int k) {
        // base case
        if (slate.size() == k) {
            results.add(List.copyOf(slate));
            return;
        } else if (idx == n) {
            return;
        } else { // recurse

            // exclude
            subsetsOfSizeKHelper(n, slate, idx + 1, results, k);

            // include
            slate.add(idx + 1);
            subsetsOfSizeKHelper(n, slate, idx + 1, results, k);
            slate.remove(slate.size() - 1);
        }

    }
}
