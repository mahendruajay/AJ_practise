package pattern_based.recursion.ik.live.session_prac1.backtracking;

/*
Given a number n, generate all possible valid parentheses.

Example:

Input: N = 1
Output: ()

Input: N = 2
Output: (()), ()()
 */

import java.util.ArrayList;
import java.util.List;

public class Parentheses {

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        List<String> results = parentheses.parentheses(3);
        System.out.println("Results: " + results);
    }

    public List<String> parentheses(int n) {
        List<String> results = new ArrayList<>();
        parenthesesHelper(n, n, new StringBuilder(), results);
        return results;
    }

    public void parenthesesHelper(int openRemaining, int closeRemaining, StringBuilder slate, List<String> results) {
        // base case
        if (closeRemaining < openRemaining) {
            return;
        } else if (openRemaining == 0 && closeRemaining == 0) {
            results.add(slate.toString());
            return;
        } else {
            if (openRemaining > 0) {
                slate.append("(");
                parenthesesHelper(openRemaining - 1, closeRemaining, slate, results);
                slate.deleteCharAt(slate.length() - 1);
            }

            if (closeRemaining > 0) {
                slate.append(")");
                parenthesesHelper(openRemaining, closeRemaining - 1, slate, results);
                slate.deleteCharAt(slate.length() - 1);
            }
        }

    }
}
