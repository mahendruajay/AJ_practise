package cracking.coding.interview.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineUnique {

    private String input;

    public DetermineUnique(String input) {
        this.input = input;
    }

    public boolean determineUniqueUsingSort() {
        if (null == input || input.isEmpty()) return false;
        if (input.length() == 1) return true;

        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean determineUniqueUsingSet() {

        if (null == input || input.isEmpty()) return false;
        if (input.length() == 1) return true;

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (charSet.contains(input.charAt(i))) {
                return false;
            } else {
                charSet.add(input.charAt(i));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String input = "";
        DetermineUnique determineUnique = new DetermineUnique(input);
        System.out.println("Using sort: " + determineUnique.determineUniqueUsingSort());
        System.out.println("Using set: " + determineUnique.determineUniqueUsingSet());

    }
}
