package com.playground.ArraysStrings;

public class LongestPalindrome {

    private static int complexity = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcdefghzahgfedcba";
        // String str = "aabaa";

        LongestPalindrome myPlaindrome = new LongestPalindrome();

        String longest = myPlaindrome.getLongestPalindrome(str);

        System.out.println(longest);

        System.out.println(LongestPalindrome.complexity);

    }

    public String getLongestPalindrome(String input) {
        if (null == input || input.length() <= 1) {
            return input;
        }

        int len = input.length();

        String longestPalindrome = null;

        for (int i = 0; i < len - 1; i++) {
            complexity++;

            int first = i;
            int second = i + 1;

            // check for twins
            if (input.charAt(first) == input.charAt(second)) {
                String pal = exploreBothWays(input, first - 1, second + 1);

                if (null == longestPalindrome) {
                    longestPalindrome = pal;
                } else if (pal.length() > longestPalindrome.length()) {
                    longestPalindrome = pal;
                }
            }

            String pal = exploreBothWays(input, second - 1, second + 1);

            if (null == longestPalindrome) {
                longestPalindrome = pal;
            }
            if (pal.length() > longestPalindrome.length()) {
                longestPalindrome = pal;
            }

        }

        return longestPalindrome;

    }

    private String exploreBothWays(String input, int left, int right) {
        while (left >= 0 && right < input.length()) {
            complexity++;

            if (input.charAt(left) == input.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }

        }

        return input.substring(left + 1, right);
    }
}
