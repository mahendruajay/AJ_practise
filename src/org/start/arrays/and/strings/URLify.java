package org.start.arrays.and.strings;

import java.util.ArrayList;
import java.util.List;

public class URLify {

    private String input;

    public URLify(String input) {
        this.input = input;
    }

    public String urilify() {
        List<Character> chars = new ArrayList<>();
        for (char c : input.toCharArray()) {
            chars.add(c);
        }

        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == ' ') {
                chars.add(i, '0');
                chars.add(i, '2');
                chars.add(i, '%');
                i = i + 3;
                chars.remove(i);
                i--;
            }
        }


        Character[] ans = chars.toArray(new Character[chars.size()]);
        char[] arr = new char[ans.length];
        for (int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }

        return new String(arr);
    }


    public static void main(String[] args) {
        String input = "Mr John Smith";
        URLify urLify = new URLify(input);
        System.out.println("ulified string is: " + urLify.urilify());
    }
}
