package pattern_based.recursion.ik.live.session_prac1.combinatorial;

/*
Letter Case Permutation
Given a String S, transform every letter to lowercase and uppercase to create another string. Return a list of all possible strings we could create.

Example: Inout: “t1D2”
Output: [“t1D2”, “t1d2”, “T1D2”, “T1d2”]

Input: “12345”
Output: [“12345”]

 */

import java.util.ArrayList;
import java.util.List;

public class LetterPermutation {


    public static void main(String[] args) {
        String input = "t1D2";

        LetterPermutation letterPermutation = new LetterPermutation();
        List<String> results = letterPermutation.letterPermutation(input);
        System.out.println("Results: " + results);

    }

    public List<String> letterPermutation(String input) {
        List<String> results = new ArrayList<>();
        letterPermutationHelper(input, new StringBuilder(), 0, results);

        return results;
    }

    public void letterPermutationHelper(String input, StringBuilder slate, int idx, List<String> results) {
        //base case
        if (idx == input.length()) {
            results.add(slate.toString());
        } else { // recursion case
            if (Character.isDigit(input.charAt(idx))) {
                slate.append(input.charAt(idx));
                letterPermutationHelper(input, slate, idx + 1, results);
                slate.deleteCharAt(slate.length() - 1);
            } else {
                slate.append(Character.toUpperCase(input.charAt(idx)));
                letterPermutationHelper(input, slate, idx + 1, results);
                slate.deleteCharAt(slate.length() - 1);

                slate.append(Character.toLowerCase(input.charAt(idx)));
                letterPermutationHelper(input, slate, idx + 1, results);
                slate.deleteCharAt(slate.length() - 1);
            }
        }
    }
}
