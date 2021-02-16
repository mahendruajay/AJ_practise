package cracking.coding.interview.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    private String one;
    private String two;

    public CheckPermutation(String one, String two) {

        this.one = one;
        this.two = two;
    }

    public boolean isPermutationUsingSort() {

        if (null == one || null == two) return false;
        if (one.length() != two.length()) return false;

        return sort(one).equals(sort(two));

    }

    public boolean isPermutationUsingMap() {

        if (null == one || null == two) return false;
        if (one.length() != two.length()) return false;

        Map<Character, Integer> charMap = constructCharMap(one);

        for (int i = 0; i < two.length(); i++) {
            Integer val = charMap.get(two.charAt(i));
            if (null == val) {
                return false;
            } else {
                val--;
                if (val == 0) {
                    charMap.remove(two.charAt(i));
                }
//              else {
//                    charMap.put(two.charAt(i), val);
//                }
            }
        }

        return true;

    }

    public Map<Character, Integer> constructCharMap(String input) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Integer val = charMap.get(input.charAt(i));
            if (null == val) {
                val = 1;
            } else {
                val++;
            }
            charMap.put(input.charAt(i), val);
        }

        return charMap;
    }

    public String sort(String input) {
        if (null == input) return "";
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String one = "ajay";
        String two = "aajy";

        CheckPermutation checkPermutation = new CheckPermutation(one, two);
        System.out.println("is permutation: " + checkPermutation.isPermutationUsingSort());
        System.out.println("is permutation: " + checkPermutation.isPermutationUsingMap());

    }
}
