package org.start.recursion_dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutationNoDups {


    public List<String> permute(String input) {

        Map<Character, Integer> frequencyTable = getFrequency(input);

        List<String> result = new ArrayList<>();
        perms("", frequencyTable, input.length(), result);
        return result;

    }

    private void perms(String prefix, Map<Character, Integer> frequency, int remaining, List<String> result) {

        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : frequency.keySet()) {

            int count = frequency.get(c);
            if (count > 0) {
                frequency.put(c, count - 1);
                perms(prefix + c, frequency, remaining - 1, result);
                frequency.put(c, count);
            }
        }
    }

    private Map<Character, Integer> getFrequency(String input) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (frequency.get(c) == null) {
                frequency.put(c, 0);
            }
            frequency.put(c, frequency.get(c) + 1);
        }

        return frequency;
    }

    public static void main(String[] args) {
        String input = "aab";

        StringPermutationNoDups stringPermutationNoDups = new StringPermutationNoDups();
        List<String> result = stringPermutationNoDups.permute(input);

        System.out.println("Result is: " + result);

    }
}
