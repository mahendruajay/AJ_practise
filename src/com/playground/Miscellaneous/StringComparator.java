package com.playground.Miscellaneous;

import java.util.Comparator;
import java.util.Map;

public class StringComparator implements Comparator<String> {
    Map<Character, Integer> key;

    public StringComparator(Map<Character, Integer> key) {
        this.key = key;
    }

    public int compare(String one, String two) {
        char oneFirst = getCapitalChar(one.charAt(0));
        char twoFirst = getCapitalChar(two.charAt(0));

        if (key.containsKey(oneFirst) && key.containsKey(twoFirst)) {
            return key.get(oneFirst) - key.get(twoFirst);
        } else if (key.containsKey(oneFirst)) {
            return -1;
        } else if (key.containsKey(twoFirst)) {
            return 1;
        }

        return one.compareTo(two);

    }

    private char getCapitalChar(char input) {
        if (input >= 'a' && input <= 'z') {
            return (char) (input - 32);
        } else {
            return input;
        }
    }
}