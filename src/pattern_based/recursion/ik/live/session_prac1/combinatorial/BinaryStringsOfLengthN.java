package pattern_based.recursion.ik.live.session_prac1.combinatorial;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringsOfLengthN {

    public static void main(String[] args) {
        List<String> results = new BinaryStringsOfLengthN().allBinaryStringOfLength(3);

        System.out.println("Results: " + results);
    }

    public List<String> allBinaryStringOfLength(int length) {
        List<String> results = new ArrayList<>();
        binaryStringHelper(length, new StringBuilder(), 0, results);
        return results;
    }

    public void binaryStringHelper(int length, StringBuilder slate, int idx, List<String> results) {
        // base case
        if (idx == length) {
            results.add(slate.toString());
        } else {
            slate.append(0);
            binaryStringHelper(length, slate, idx + 1, results);
            slate.deleteCharAt(slate.length() - 1);

            slate.append(1);
            binaryStringHelper(length, slate, idx + 1, results);
            slate.deleteCharAt(slate.length() - 1);
        }
    }
}
