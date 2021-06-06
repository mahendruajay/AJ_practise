package pattern_based.recursion.ik.live.session_prac1.combinatorial;

import java.util.ArrayList;
import java.util.List;

public class PermutationsNoRepetition {

    public static void main(String[] args) {
        List<Character> input = new ArrayList<>();
        input.add('a');
        input.add('b');
        input.add('c');

        PermutationsNoRepetition permutationsNoRepetition = new PermutationsNoRepetition();
        permutationsNoRepetition.permute(input);
    }

    public void permute(List<Character> input) {
        permuteHelper(input, new StringBuilder(), 0);
    }

    public void permuteHelper(List<Character> input, StringBuilder slate, int idx) {
        // base case
        if (idx == input.size()) {
            System.out.println(slate.toString());
        } else { // recursion
            for (int i = idx; i < input.size(); i++) {
                swap(input, i, idx);
                slate.append(input.get(idx));
                permuteHelper(input, slate, idx + 1);
                slate.deleteCharAt(slate.length() - 1);
                swap(input, i, idx);

            }
        }
    }

    public void swap(List<Character> input, int first, int second) {
        char temp = input.get(first);
        input.set(first, input.get(second));
        input.set(second, temp);
    }
}
