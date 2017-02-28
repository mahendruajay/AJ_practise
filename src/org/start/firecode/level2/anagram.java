package org.start.firecode.level2;

import java.util.Arrays;

public class anagram {

    public static boolean isAnagram(String input1, String input2) {
        if (null == input1 || null == input2) {
            return false;
        }

        char[] input1Arr = input1.toCharArray();
        Arrays.sort(input1Arr);
        String sortedInput1 = new String(input1Arr);

        char[] input2Arr = input2.toCharArray();
        Arrays.sort(input2Arr);
        String sortedInput2 = new String(input2Arr);

        return sortedInput1.equals(sortedInput2);

    }

    public static void main(String[] args) {
        boolean result = isAnagram("abcde", "acdbe");
    }

}
