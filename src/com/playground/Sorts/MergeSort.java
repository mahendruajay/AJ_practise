package com.playground.Sorts;

public class MergeSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = {5};
        sort.mergeSort(arr, 0, arr.length - 1);

        for (int item : arr) {
            System.out.print(item + " ");
        }

    }

    public void mergeSort(int[] input, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    public void merge(int[] input, int start, int mid, int end) {
        // Allocate space for left part
        int[] left = new int[mid - start + 1];

        // Allocate space for right part
        int[] right = new int[end - mid];

        // Populate left array
        int j = 0;
        for (int i = start; i <= mid; i++) {
            left[j] = input[i];
            j++;
        }

        // Populate right array
        j = 0;
        for (int i = mid + 1; i <= end; i++) {
            right[j] = input[i];
            j++;
        }

        // Merge routine (merge left and right)
        int i = 0;
        j = 0;

        for (int k = start; k <= end; k++) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    input[k] = left[i];
                    i++;
                } else {
                    input[k] = right[j];
                    j++;
                }
            } else {
                if (i < left.length) {
                    input[k] = left[i];
                    i++;
                } else if (j < right.length) {
                    input[k] = right[j];
                    j++;
                }
            }

        }

    }

}
