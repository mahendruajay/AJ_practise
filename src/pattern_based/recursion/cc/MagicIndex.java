package pattern_based.recursion.cc;

/*
A magic index in an array is defined to be an index such that A[i] = i. Given a sorted array of distinct
integers write a method to find magic index, if one exists in array A.

The values in the array can have duplicates.

Example:

Input: {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}
Output: 7

Input: {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13}
Output: 2

 */

public class MagicIndex {

    public static void main(String[] args) {

        int[] input1 = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] input2 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        MagicIndex magicIndex = new MagicIndex();
        System.out.println("Results input1: " + magicIndex.magicIndex(input1));
        System.out.println("Results input2: " + magicIndex.magicIndex(input2));
    }

    public int magicIndex(int[] input) {

        return magicIndexHelper(input, 0, input.length - 1);

    }

    public int magicIndexHelper(int[] input, int start, int end) {
        if (start > end) {
            return -1;
        } else {

            int mid = (end - start) / 2 + start;
            if (input[mid] == mid) {
                return mid;
            }
            int rightBoundary = Math.min(mid - 1, input[mid]);
            int result = magicIndexHelper(input, start, rightBoundary);
            if (result > 0) {
                return result;
            }


            int leftBoundary = Math.max(mid + 1, input[mid]);
            result = magicIndexHelper(input, leftBoundary, end);
            return result;

        }
    }
}