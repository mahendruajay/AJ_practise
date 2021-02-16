package uplevel.recursion.cls;


import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        String input = "1234";
        powerSet(input, 0, new StringBuilder());
        System.out.println("\nSubset of size k");
        powerSetSizeK(input, 0, 1, new StringBuilder());

        System.out.println("\nSubset of sum k");
        int[] inp = {1,2,3,4};
        powerSetSumEquals(inp, 0, 3, 0, new StringBuilder());

        long[] l = {4, -5,7};
        long tar = 2;

        boolean r = check_if_sum_possible(l, tar);

        System.out.println(r);

    }

    public static void powerSet(String input, int level, StringBuilder builder){
        if(level == input.length()){
            System.out.println(builder.toString());
        } else{
          powerSet(input, level+1, builder);

          builder.append(input.charAt(level));
          powerSet(input, level+1, builder);
          builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void powerSetSizeK(String input, int level, int k, StringBuilder builder){

        if(builder.length() == k){
            System.out.println(builder.toString());
            return;
        }
        if(level == input.length()){
            return;
        }
        // exclude
        powerSetSizeK(input, level+1, k, builder);

        // include
        builder.append(input.charAt(level));
        powerSetSizeK(input, level+1, k, builder);
        builder.deleteCharAt(builder.length()-1);

    }

    public static void powerSetSumEquals(int[] input, int level, int target, int runningSum, StringBuilder builder){
        if(runningSum > target){
            return;
        }
        if(target == runningSum){
            System.out.println(builder.toString());
            return;
        }
        if(level == input.length){
            return;
        }

        // exclude
        powerSetSumEquals(input, level+1, target, runningSum, builder);

        builder.append(input[level]);
        powerSetSumEquals(input, level+1, target, runningSum+input[level], builder);
        builder.deleteCharAt(builder.length()-1);
    }

    /*
    Possible To Achieve Target Sum?

    Given a set of integers and a target value k, find a non-empty subset that sums up to k.

    Example One
    Input: [2 4 8], k = 6
    Output: True
    Because 2+4=6.

    Example Two
    Input: [2 4 6], k = 5
    Output: False

    Because no subset of numbers from the input sums up to 5.
     */

    static boolean check_if_sum_possible(long[] arr, long k) {

        List<Long> soFar = new ArrayList();
        return sumHelper(arr, 0, k, 0L, soFar);

    }

    public static boolean sumHelper(long[] input, int level, long target, long runningSum, List<Long> soFar){

        if(runningSum > target){
            return false;
        }

        if(runningSum == target && !soFar.isEmpty()){
            return true;
        }
        if(level >= input.length){
            return false;
        }
        boolean excl = sumHelper(input, level+1, target, runningSum, soFar);
        soFar.add(input[level]);
        boolean incl = sumHelper(input, level+1, target, runningSum+input[level], soFar);
        soFar.remove(soFar.size()-1);

        return excl | incl;
    }
}
