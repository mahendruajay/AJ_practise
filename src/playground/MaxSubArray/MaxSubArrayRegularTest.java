package playground.MaxSubArray;

import java.util.Scanner;

public class MaxSubArrayRegularTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] stockPrices = new int[num];
        int[] diffArray = new int[num];

        for (int i = 0; i < num; i++) {
            stockPrices[i] = in.nextInt();
        }

        diffArray[0] = 0;
        for (int i = 1; i < num; i++) {
            diffArray[i] = stockPrices[i] - stockPrices[i - 1];
        }

        findMaxSubArray(diffArray);

    }

    public static void findMaxSubArray(int[] diffArray) {
        int start = 0;
        int end = diffArray.length - 1;
        int sum = 0;
        int tempMaxSum = 0;
        int tempStartIndex = 0;
        int tempEndIndex = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxSum = 0;

        for (int i = start + 1; i <= end; i++) {

            sum = sum + diffArray[i];

            if (sum > tempMaxSum) {
                tempMaxSum = sum;
                tempEndIndex = i;
            }
            if (sum < 0) {

                if (tempMaxSum > maxSum) {
                    maxSum = tempMaxSum;
                    startIndex = tempStartIndex;
                    endIndex = tempEndIndex;
                }

                tempStartIndex = i;
                tempEndIndex = i;

                sum = 0;
                tempMaxSum = 0;
            }
        }

        if (tempMaxSum > maxSum) {
            maxSum = tempMaxSum;
            startIndex = tempStartIndex;
            endIndex = tempEndIndex;
        }

        System.out.println("Start : " + startIndex);
        System.out.println("End : " + endIndex);
        System.out.println("Profit : " + maxSum);

    }

}
