package pattern_based.recursion.ik.live.session_prac1.combinatorial;

import java.util.ArrayList;
import java.util.List;

public class DecimalStringsOfLengthN {

    public static void main(String[] args) {
        List<String> results = new DecimalStringsOfLengthN().decimalStrings(2);
        System.out.println("Results: " + results);

        System.out.println("Results size: " + results.size());
    }

    public List<String> decimalStrings(int length) {
        List<String> results = new ArrayList<>();
        decimalStringHelper(length, new StringBuilder(), 0, results);
        return results;

    }

    public void decimalStringHelper(int length, StringBuilder slate, int idx, List<String> results) {
        // base case
        if (idx == length) {
            results.add(slate.toString());
        } else { // recursion case
            for (int i = 0; i < 10; i++) {
                slate.append(i);
                decimalStringHelper(length, slate, idx + 1, results);
                slate.deleteCharAt(slate.length() - 1);
            }
        }
    }
}
