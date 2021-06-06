package pattern_based.dynamic_programming.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualSubsetPartition {

    public static List<Boolean> equalSubSetSumPartition(List<Integer> s) {

        // typical combinatorial problem where we can either choose to include the
        // current element or exclude it

        // the state we will maintain is :
        // Given an index and a sum, check if adding the number OR just without adding
        // the number, the sum can be achieved

        int sum = 0;
        int negSum = 0;
        int posSum = 0;
        for (int num : s) {
            if (num < 0)
                negSum += num;
            else
                posSum += num;
        }

        sum = negSum + posSum;
        int range = posSum - negSum;

        if (sum % 2 != 0)
            return new ArrayList<Boolean>();
        int target = sum / 2;

        boolean[][] dp = new boolean[s.size()][range + 1];
        // subtracting from negSum actually gives the right index of the column
        // corresponding to s.get(i) + 0
        dp[0][s.get(0) - negSum] = true;

        for (int i = 1; i < s.size(); i++) {
            dp[i][s.get(i) - negSum] = true;
            for (int j = 0; j < range; j++) {

                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    // this is the main trick, instead of subtracting from the sum, we add up to the
                    // target so that in the future
                    // the sum j + current number will be set as true
                    dp[i][j + s.get(i)] = true;
                }

            }

        }

        Boolean[] finalList = new Boolean[s.size()];

        target -= negSum;
        int trueCount = 0;
        int falseCount = 0;

        if (dp[s.size() - 1][target]) {

            for (int i = s.size() - 1; i >= 0; i--) {

                // if the current number made a contribution to the target, its true, hence it
                // belongs to the true category
                if ((i > 0 && !dp[i - 1][target] && dp[i][target]) || i == 0) {
                    if(i == 0)
                        finalList[i] = dp[i][target];
                    else
                        finalList[i] = true;
                    // remember the final target is always target - negSum as the array columns
                    // start from negSum (-3) to posSum (23)
                    // so the column spans from 0 to 26, with 0 to 3 being for negative numbers and
                    // 4 to 26 for positive numbers
                    target = (target - s.get(i));
                    trueCount++;
                } else {
                    finalList[i] = false;
                    falseCount++;
                }

            }
            return trueCount > 0 && falseCount > 0 ? Arrays.asList(finalList) : new ArrayList<Boolean>();
        } else {
            return new ArrayList<Boolean>();
        }

    }

    public static void main(String[] args) {
        List<Integer> inp = Arrays.asList(new Integer[]{10,-3,7,2,1,3});
        List<Boolean> result = equalSubSetSumPartition(inp);
        System.out.println(result);

    }
}
