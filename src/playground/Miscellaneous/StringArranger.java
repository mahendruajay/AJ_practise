package playground.Miscellaneous;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringArranger {

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[] array = {'T', 'A', 'M'};
        String[] words = {"Marina", "Tom", "Pop", "ana", "Cat"};

        Map<Character, Integer> key = new LinkedHashMap<Character, Integer>();

        for (int i = 0; i < array.length; i++) {
            key.put(array[i], i);
        }

        Arrays.sort(words, new StringComparator(key));

        for (String word : words) {
            System.out.println(word);
        }

    }
}
