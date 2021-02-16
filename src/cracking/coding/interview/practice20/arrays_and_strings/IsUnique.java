package cracking.coding.interview.practice20.arrays_and_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {


    public static void main(String[] args) {
        String input = "bb";
        System.out.println("Is Unique Using Set: " + isUniqueUsingSet(input));
        System.out.println("Is Unique Using Sort: " + isUniqueUsingSort(input));
    }

    public static boolean isUniqueUsingSet(String input){
        if (input == null || input.isEmpty()) return true;

        Set<Character> unique = new HashSet();

        for (int i=0; i<input.length(); i++){
            if (unique.contains(input.charAt(i))){
                return false;
            } else {
                unique.add(input.charAt(i));
            }
        }
        return true;
    }

    public static boolean isUniqueUsingSort(String input){
        if (null == input || input.isEmpty()){
            return true;
        }
        char[] strArr = input.toCharArray();
        Arrays.sort(strArr);
        for(int i=0; i< strArr.length-1; i++){
            if (strArr[i] == strArr[i+1]){
                return false;
            }
        }
        return true;
    }
}
