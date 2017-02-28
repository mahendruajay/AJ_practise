package org.start.recursion_dynamic;

import java.util.Arrays;

public class ClimbingStairs {

    public static int climbStairsBottomUpMemo(int stairs, int[] memo) {
        if (stairs == 0) {
            return 1;
        }
        if (stairs == 1) {
            return 1;
        }
        if (stairs == 2) {
            return 2;
        }
        if (stairs == 3) {
            return 4;
        }
        if (memo[stairs] > -1) {
            return memo[stairs];
        }
        memo[stairs] = climbStairsBottomUpMemo(stairs - 1, memo) +
                climbStairsBottomUpMemo(stairs - 2, memo) + climbStairsBottomUpMemo(stairs - 3, memo);

        return memo[stairs];

    }

    public static int climbStairsTopDownDynamic(int stairs) {

        if (stairs < 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        int third = 2;

        int result = 0;

        if (stairs == 0) {
            return first;
        }
        if (stairs == 1) {
            return second;
        }
        if (stairs == 2) {
            return third;
        }


        for (int i = 3; i <= stairs; i++) {
            result = first + second + third;
            first = second;
            second = third;
            third = result;

        }


        return result;

    }

    public static void main(String[] args) {
        int stairs = 4;
        int[] memo = new int[stairs + 1];
        Arrays.fill(memo, -1);
        int ways1 = climbStairsBottomUpMemo(stairs, memo);
        System.out.println("Stairs bottom up :" + ways1);

        int ways2 = climbStairsTopDownDynamic(stairs);
        System.out.println("Stairs top down :" + ways2);


    }


}
