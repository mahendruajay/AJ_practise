package playground.general;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String input1, String input2) {

        if (input1 == null || input2 == null || input1.length() != input2.length()) return false;

        int charcount = 0;
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            Character c1 = input1.charAt(i);
            Character c2 = input2.charAt(i);

            if (h1.get(c1) != h2.get(c2)) return false;
            if (h1.get(c1) == null) {
                h1.put(c1, charcount);
                h2.put(c2, charcount);
                charcount++;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        boolean result = isIsomorphic("aba", "bab");

        System.out.println("Result is :" + result);


    }
}
