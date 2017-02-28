package com.playground.RecursionDynamic;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations2 {

    static int count = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcde67";

        StringPermutations2.permutations(s);

        System.out.println("Count : " + count);
    }

    public static void permutations(String input) {
        // List<List<String>> perms = new ArrayList<List<String>>();
        List<String> tempPerms = new ArrayList<String>();
        tempPerms.add(input.substring(0, 1));

        int i = 1;
        while (tempPerms.size() > 0 && i < input.length()) {
            List<String> iter = new ArrayList<String>(tempPerms);
            tempPerms.clear();

            count++;

            for (String str : iter) {
                count++;
                for (int j = 0; j <= str.length(); j++) {
                    count++;

                    String newPerm = insertCharAt(str, input.charAt(i), j);
                    tempPerms.add(newPerm);
                }
            }

            i++;
        }

        for (String str : tempPerms) {
            System.out.print(str + ", ");
        }
        System.out.println();

    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;

    }

}
