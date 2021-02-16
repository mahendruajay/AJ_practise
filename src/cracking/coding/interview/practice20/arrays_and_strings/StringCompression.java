package cracking.coding.interview.practice20.arrays_and_strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {

    public static void main(String[] args) {
        String input = "aabcccddd";
        String input1 = "abc";
        System.out.println("Result: " + compressionLinearScan(input));
        System.out.println("Result: " + compressionLinkedHashMap(input));
    }

    public static String compressionLinearScan(String input){
        if(null == input || input.length() <=2){
            return input;
        }
        StringBuilder builder = new StringBuilder();
        char curr = input.charAt(0);
        int count =1;
        int j = 1;
        while (j < input.length()){
            if(input.charAt(j) == curr){
                count++;
            } else {
                builder.append(curr);
                builder.append(count);
                curr = input.charAt(j);
                count =1;
            }
            j++;
        }

        builder.append(curr);
        builder.append(count);

        System.out.println("Compressed: " + builder.toString() + " Length: "+ builder.length());
        System.out.println("Original: " + input + " Length: "+ input.length());

        if (builder.length() < input.length()){
            return builder.toString();
        } else {
            return input;
        }

    }

    public static String compressionLinkedHashMap(String input){
        if(null == input || input.length() <=2){
            return input;
        }

        Map<Character, Integer> freq = new LinkedHashMap<>();
        for(char c: input.toCharArray()){
            freq.compute(c, (k,v) -> {
                return v == null ? 1 : v +1;
                }
            );
        }
        System.out.println(freq);

        StringBuilder builder = new StringBuilder();

        for(Character c: freq.keySet()){
            builder.append(c);
            builder.append(freq.get(c));
        }

        System.out.println("Compressed: " + builder.toString() + " Length: "+ builder.length());
        System.out.println("Original: " + input + " Length: "+ input.length());

        if (builder.length() < input.length()){
            return builder.toString();
        } else {
            return input;
        }
    }
}
