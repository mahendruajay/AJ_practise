package uplevel.recursion.cls;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationWithDuplicates {

    public static void main(String[] args) {
        String input = "12132";
        Map<String, Integer> freq = new HashMap<>();
        permWithDuplicatesUsingHashSet(input.toCharArray(), 0, new StringBuilder(), freq);
        System.out.println(freq);

        System.out.println("Another way");

        Map<Character, Integer> freq1 = buildFreqTable(input.toCharArray());
        permWithDupsUsingHashMap("", input.length(), freq1);


    }

    public static void permWithDupsUsingHashMap(String prefix, int remaining, Map<Character, Integer> freq1){
        if(remaining == 0){
            System.out.println(prefix);
            return;
        }

        for(char c: freq1.keySet()){
            int count = freq1.get(c);
            if(count > 0){
                freq1.put(c, count-1);
                permWithDupsUsingHashMap(prefix+c, remaining-1, freq1);
                freq1.put(c, count);
            }
        }
    }

    public static Map<Character, Integer> buildFreqTable(char[] input){
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: input){
            freq.compute(c, (k,v) -> {
                return v == null ? 1: (v+1);
            });
        }
        return freq;
    }

    public static void permWithDuplicatesUsingHashSet(char[] input, int level, StringBuilder builder, Map<String, Integer> freq){
        if(level == input.length){
            String res = builder.toString();
            System.out.println(res);
            freq.compute(res, (k,v) -> {
               return v == null ? 1 : (v +1);
            });

        } else{
            Set<Character> dups = new HashSet<>();
            for(int i=level; i< input.length; i++){
                if(dups.contains(input[i])){
                    continue;
                }
                dups.add(input[i]);

                swap(input, i, level);
                builder.append(input[level]);
                permWithDuplicatesUsingHashSet(input, level+1, builder, freq);
                builder.deleteCharAt(builder.length()-1);
                swap(input, i, level);
            }

        }
    }

    public static void swap(char[] input, int first, int second){
        char temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
}
