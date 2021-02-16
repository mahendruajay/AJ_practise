package cracking.coding.interview.strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

    private String input;

    public PalindromePermutation(String input) {
        this.input = input;
    }

    public boolean isPalPermute() {

        Set<Character> charSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            char ch = Character.toLowerCase(c);
            if (ch != ' ') {
                if (charSet.contains(ch)) charSet.remove(ch);
                else charSet.add(Character.toLowerCase(ch));
            }
        }

        return (charSet.isEmpty() || charSet.size() == 1);

    }


    public static void main(String[] args) {
        String input = "Tact Coap";
        PalindromePermutation palindromePermutation = new PalindromePermutation(input);

        System.out.println("is palindrome permute: " + palindromePermutation.isPalPermute());

    }
}
