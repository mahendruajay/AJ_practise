package com.playground.MaxSubArray;

public class MaxSubArrayAnswer {
    private int low;
    private int high;
    private int maxSum;

    public MaxSubArrayAnswer(int low, int high, int maxSum) {
        this.low = low;
        this.high = high;
        this.maxSum = maxSum;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }

    public int getMaxSum() {
        return maxSum;
    }


}
