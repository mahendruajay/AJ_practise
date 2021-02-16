package cracking.coding.interview.recursion_dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    public <E> List<List<E>> getSubsets(List<E> set) {
        List<List<E>> result = new ArrayList<>();
        List<E> emptySet = new ArrayList<>();

        result.add(emptySet);

        for (E member : set) {
            List<List<E>> moreSubsets = new ArrayList<>();

            for (List<E> subs : result) {
                List<E> subResult = new ArrayList<>();
                subResult.addAll(subs);
                subResult.add(member);
                moreSubsets.add(subResult);
            }
            result.addAll(moreSubsets);

        }

        return result;

    }

    public <E> List<List<E>> getSubsetsComb(List<E> set) {

        List<List<E>> results = new ArrayList<>();

        int number = 1 << set.size();

        for (int i = 0; i < number; i++) {
            List<E> subsets = getCombResult(i, set);
            results.add(subsets);
        }

        return results;
    }

    private <E> List<E> getCombResult(int bits, List<E> set) {
        List<E> subsets = new ArrayList<>();

        int index = 0;

        for (int j = bits; j > 0; j = j >> 1) {
            if ((j & 1) == 1) {
                subsets.add(set.get(index));
            }
            index++;
        }

        return subsets;

    }


    public static void main(String[] args) {

        Subsets subsets = new Subsets();

        List<Character> chars = Arrays.asList('a', 'b', 'c');
        List<Integer> ints = Arrays.asList(1, 2, 3);

        List<List<Character>> result = subsets.getSubsets(chars);
        System.out.println("Result is: " + result);

        List<List<Integer>> result1 = subsets.getSubsets(ints);
        System.out.println("Result is: " + result1);


        List<List<Character>> result2 = subsets.getSubsetsComb(chars);
        System.out.println("Result is: " + result2);

        List<List<Integer>> result3 = subsets.getSubsetsComb(ints);
        System.out.println("Result is: " + result3);

    }
}
