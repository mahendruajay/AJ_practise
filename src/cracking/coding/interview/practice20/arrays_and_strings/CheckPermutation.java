package cracking.coding.interview.practice20.arrays_and_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckPermutation {

    public static void main(String[] args) {
        String one = "ajay";
        String two = "aajj";

        System.out.println("Check Permutation using sort: " + checkPermutationUsingSort(one, two));
        System.out.println("Check Permutation using sort: " + checkPermutationUsingSort(one, two));

    }

    public static boolean checkPermutationUsingSort(String one, String two){
        if(null == one || null == two) {
            return false;
        }
        if(one.length() != two.length()){
            return false;
        }
        if (sort(one).equals(sort(two))) return true;

        return false;
    }

    public static String sort(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }

    public static boolean checkPermutationUsingSet(String one, String two){
        if(null == one || null == two) {
            return false;
        }
        if(one.length() != two.length()){
            return false;
        }

        Set<Character> chars = new HashSet<>();
        for(int i =0; i< one.length(); i++){
            chars.add(one.charAt(i));
        }
        for(int i=0; i< two.length(); i++){
            if(!chars.contains(two.charAt(i))){
                return false;
            } else{
                chars.remove(two.charAt(i));
            }
        }

        return true;
    }
}
