package com.playground.launch;

import java.util.Comparator;

public class StringLengthComprator implements Comparator<String> {
    public int compare(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return str1.compareTo(str2);
        }
        return ((Integer) str2.length()).compareTo((Integer) str1.length());
    }
}
