package cracking.coding.interview.recursion_dynamic;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {


    private static int inputTimes = 1;
    private static int resultTimes = 0;
    private static int permuteTimes = 0;

    public List<String> permute(String input) {
        List<String> result = new ArrayList<>();
        result.add(input.substring(0, 1));

        for (int i = 1; i < input.length(); i++) {

            char currentChar = input.charAt(i);
            List<String> subResult = new ArrayList<>();

            for (String previousString : result) {
                List<String> permutations = makePermutations(previousString, currentChar);
                subResult.addAll(permutations);
                resultTimes++;
            }

            result = subResult;
            inputTimes++;

        }

        return result;

    }

    private List<String> makePermutations(String input, char c) {
        List<String> permutations = new ArrayList<>();
        for (int i = 0; i <= input.length(); i++) {
            String first = input.substring(0, i);
            String second = input.substring(i);
            String permute = first + c + second;
            permutations.add(permute);
            permuteTimes++;
        }

        return permutations;

    }

    public void permuteRecHelper(String prefix, String remaining, List<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }
        int len = remaining.length();

        for (int i = 0; i < len; i++) {
            String before = remaining.substring(0, i);
            String after = remaining.substring(i + 1);
            char c = remaining.charAt(i);
            permuteRecHelper(prefix + c, before + after, result);
        }

    }

    public List<String> permuteRec(String input) {
        List<String> permutations = new ArrayList<>();
        permuteRecHelper("", input, permutations);
        return permutations;
    }


    public static void main(String[] args) {
        String input = "abc";

        StringPermutation stringPermutation = new StringPermutation();

        List<String> result = stringPermutation.permute(input);

        System.out.println("Permute is: " + result + " Length is: " + result.size());

        System.out.println("inputTimes :" + inputTimes + " resultTimes :" + resultTimes + " permuteTimes :" + permuteTimes);

        System.out.println("Total Times :" + inputTimes * resultTimes * permuteTimes);

        List<String> permRec = stringPermutation.permuteRec(input);

        System.out.println("Rec result is: " + permRec);

    }
}
