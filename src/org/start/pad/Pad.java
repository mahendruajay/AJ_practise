package org.start.pad;

import java.util.HashMap;
import java.util.Map;

public class Pad {

    public static void main(String[] args) {

        String one = "fcrxzwscanmligyxyvym";
        String two = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        int val = numberNeeded(one, two);
        System.out.println(val);

    }

    public static int numberNeeded(String first, String second) {
        int numOfDeletions = 0;
        Map<Character, Integer> charMap = constructCharMap(second);
        for (char c : first.toCharArray()) {
            if (!charMap.containsKey(c)) {
                numOfDeletions++;
            } else {
                Integer value = charMap.get(c);
                value--;
                if (value == 0) {
                    charMap.remove(c);
                } else {
                    charMap.put(c, value);
                }
            }
        }

        for (Character c : charMap.keySet()) {
            numOfDeletions++;
        }

        return numOfDeletions;
    }

    private static Map<Character, Integer> constructCharMap(String input) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (char c : input.toCharArray()) {
            Integer value = charMap.get(c);
            if (null != value) {
                value = value + 1;
            } else {
                value = new Integer(1);
            }
            charMap.put(c, value);
        }

        int total = 0;
        for (Character c : charMap.keySet()) {
            total = total + charMap.get(c);
        }

        System.out.println("Map Total is:" + total);

        return charMap;
    }
}
