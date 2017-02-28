package com.playground.MaxSubArray;

import java.util.Scanner;

public class MaxSubArrayTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int stockPrices[] = new int[num];
        for (int i = 0; i < num; i++) {
            stockPrices[i] = in.nextInt();
        }

        int[] diffArray = new int[num];
        diffArray[0] = 0;
        for (int i = 1; i < num; i++) {
            diffArray[i] = stockPrices[i] - stockPrices[i - 1];
        }

        MaxSubArrayTest maxSub = new MaxSubArrayTest();

        MaxSubArrayAnswer answer = maxSub.findMaxSubArray(diffArray, 0,
                diffArray.length - 1);

        System.out.println("Start is: " + (answer.getLow() - 1));
        System.out.println("End is: " + answer.getHigh());
        System.out.println("Max Profit is: " + answer.getMaxSum());

    }

    public MaxSubArrayAnswer findMaxSubArray(int[] diffArray, int start, int end) {
        if (start == end) {
            return new MaxSubArrayAnswer(start, end, diffArray[start]);
        }
        int mid = (start + end) / 2;
        MaxSubArrayAnswer leftAnswer = findMaxSubArray(diffArray, start, mid);
        MaxSubArrayAnswer rightAnswer = findMaxSubArray(diffArray, mid + 1, end);
        MaxSubArrayAnswer crossingAnswer = finMaxCrossingSubarray(diffArray,
                start, mid, end);

        if (leftAnswer.getMaxSum() > rightAnswer.getMaxSum()
                && leftAnswer.getMaxSum() > crossingAnswer.getMaxSum()) {
            return leftAnswer;
        } else if (rightAnswer.getMaxSum() > leftAnswer.getMaxSum()
                && rightAnswer.getMaxSum() > crossingAnswer.getMaxSum()) {
            return rightAnswer;
        } else {
            return crossingAnswer;
        }

    }

    public MaxSubArrayAnswer finMaxCrossingSubarray(int[] diffArray, int low,
                                                    int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;

        for (int i = mid; i >= low; i--) {
            sum = sum + diffArray[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum = sum + diffArray[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new MaxSubArrayAnswer(maxLeft, maxRight, leftSum + rightSum);

    }

}
