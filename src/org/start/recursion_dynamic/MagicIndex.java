package org.start.recursion_dynamic;

public class MagicIndex {

    public static int magicIndex(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        }

        int leftIndex = Math.min(mid - 1, arr[mid]);
        int leftResult = magicIndex(arr, start, leftIndex);
        if (leftResult >= 0) {
            return leftResult;
        }

        int rightIndex = Math.max(mid + 1, arr[mid]);
        int rightResult = magicIndex(arr, rightIndex, end);

        return rightResult;

    }


    public static void main(String[] args) {
        int[] arr1 = {-40, 2, 2, 5, 5, 6, 7, 7, 7};
        int[] arr2 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

        int magicIndex1 = magicIndex(arr1, 0, arr1.length - 1);
        int magicIndex2 = magicIndex(arr2, 0, arr2.length - 1);

        System.out.println("Magic index for arr1 is: " + magicIndex1);
        System.out.println("Magic index for arr1 is: " + magicIndex2);
    }
}
