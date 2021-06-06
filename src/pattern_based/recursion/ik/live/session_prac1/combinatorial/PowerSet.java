package pattern_based.recursion.ik.live.session_prac1.combinatorial;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3);

        PowerSet powerSet = new PowerSet();
        List<List<Integer>> results = powerSet.powerSet(input);

        System.out.println("Results :" + results);
    }

    public List<List<Integer>> powerSet(List<Integer> input) {
        List<List<Integer>> results = new ArrayList<>();
        powerSetHelper(input, new ArrayList<Integer>(), 0, results);
        return results;
    }

    public void powerSetHelper(List<Integer> input, List<Integer> slate, int idx, List<List<Integer>> results) {
        // base case
        if (idx == input.size()) {
            results.add(List.copyOf(slate));
        } else { // recursion
            // exclude
            powerSetHelper(input, slate, idx + 1, results);

            // include
            slate.add(input.get(idx));
            powerSetHelper(input, slate, idx + 1, results);
            slate.remove(slate.size() - 1);
        }

    }
}
