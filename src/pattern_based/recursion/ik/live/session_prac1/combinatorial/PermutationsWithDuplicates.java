package pattern_based.recursion.ik.live.session_prac1.combinatorial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsWithDuplicates {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(2);
        input.add(3);

        PermutationsWithDuplicates permutationsWithDuplicates = new PermutationsWithDuplicates();
        List<String> results = permutationsWithDuplicates.permuteWithDuplicates(input);
        System.out.println("Results :" + results);
    }

    public List<String> permuteWithDuplicates(List<Integer> input) {
        List<String> results = new ArrayList<>();

        permuteWithDuplicatesHelper(input, new StringBuilder(), 0, results);
        return results;
    }

    public void permuteWithDuplicatesHelper(List<Integer> input, StringBuilder slate, int idx, List<String> results) {
        // base case
        if (idx == input.size()) {
            results.add(slate.toString());
        } else { // recursion case
            // maintain cache for each level of the recursion
            Set<Integer> cache = new HashSet<>();
            for (int i = idx; i < input.size(); i++) {
                if (!cache.contains(input.get(i))) { // only permute if we have not seen an element at the same level
                    cache.add(input.get(i));
                    swap(input, i, idx);

                    slate.append(input.get(idx));
                    permuteWithDuplicatesHelper(input, slate, idx + 1, results);
                    slate.deleteCharAt(slate.length() - 1);

                    swap(input, i, idx);
                }
            }
        }
    }

    public void swap(List<Integer> input, int first, int second) {
        Integer temp = input.get(first);
        input.set(first, input.get(second));
        input.set(second, temp);
    }
}
