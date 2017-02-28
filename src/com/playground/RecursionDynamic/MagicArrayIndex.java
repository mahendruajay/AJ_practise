package com.playground.RecursionDynamic;

public class MagicArrayIndex {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        MagicArrayIndex magic = new MagicArrayIndex();

        int res = magic.magicFast(arr, 0, arr.length - 1);

        System.out.println(res);

    }

    public int magicFast(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }

        int midIndex = (start + end) / 2;

        int midValue = array[midIndex];
        if (midValue == midIndex) {
            return midIndex;
        }

        // Search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        // Search right
        int rightIndex = Math.min(midIndex + 1, midValue);
        int right = magicFast(array, rightIndex, end);
        return right;

    }

}
