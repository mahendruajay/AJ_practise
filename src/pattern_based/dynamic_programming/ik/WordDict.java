package pattern_based.dynamic_programming.ik;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordDict {

    public static int wordBreakCount(List<String> dictionary, String txt) {
        // Write your code here

        boolean[][] dp = new boolean[txt.length()][txt.length()];
        char[] input = txt.toCharArray();
        Set<String> dict = new HashSet<>(dictionary);

        for(int i=0; i< dp.length; i++){
            for(int j=0; j< dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int count = 0;

        int len = 1;

            for (int i = 0; i < input.length; i++) {
                for (int j = i; j < input.length; j++) {

                    int firstIndex = j - len + 1;
                    int secondIndex = j;

                    String curr = new String(input, firstIndex, secondIndex - firstIndex + 1);

                    if (dict.contains(curr)) {
                        dp[firstIndex][secondIndex] = true;
                        if(firstIndex ==0) {
                            count++;
                        }
                        continue;
                    }

                    for (int k = firstIndex; k < secondIndex; k++) {
                        if (dp[firstIndex][k] && dp[k+1][secondIndex]) {
                            dp[firstIndex][secondIndex] = true;
                            if(firstIndex ==0){
                                count++;
                            }
                            break;
                        }
                    }


                }
                len++;
            }

        System.out.println();
        System.out.println();

        System.out.print("     ");
        for(char c: input){
            System.out.print(c + "     ");
        }

        System.out.println();

        for(int i=0; i< dp.length; i++){
            System.out.print(input[i] + "  ");
            for(int j=0; j< dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return count;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList(new String[]{"awe", "is", "kick", "kickstart", "start", "some", "awesome"});

        String input = "kickstartisawesome";
        System.out.println(wordBreakCount(dict, input));
    }


}
