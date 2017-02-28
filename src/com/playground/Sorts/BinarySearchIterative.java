package com.playground.Sorts;

public class BinarySearchIterative {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinarySearchIterative search = new BinarySearchIterative();
        int[] input = {1, 3, 4, 5, 8, 10, 11, 15};

        int result = search.binarySearch(input, 0, input.length - 1, 16);

        System.out.println(result);

    }

    public int binarySearch(int[] input, int start, int end, int target) {

        while (start <= end) {
            int mid = (start + end) / 2;

            int midValue = input[mid];

            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }

}
