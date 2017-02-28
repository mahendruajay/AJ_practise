package com.playground.Sorts;

import java.util.Random;

public class QuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] arr = {2};

        sort.quickSort(arr, 0, arr.length - 1);

        for (int item : arr) {
            System.out.print(item + " ");
        }

    }

    public void quickSort(int[] input, int start, int end) {
        if (start < end) {
            int randomPartition = randomizedPartition(input, start, end);
            quickSort(input, start, randomPartition - 1);
            quickSort(input, randomPartition + 1, end);
        }

    }

    public int randomizedPartition(int[] input, int start, int end) {
        int random = getRandomNumber(start, end);

        // int temp = input[random];
        // input[random] = input[start];
        // input[start] = temp;

        swap(input, start, random);

        int pivot = input[start];
        int i = start;

        for (int j = start + 1; j <= end; j++) {
            if (input[j] <= pivot) {
                i = i + 1;

                // temp = input[j];
                // input[j] = input[i];
                // input[i] = temp;

                swap(input, i, j);
            }
        }

        // temp = input[i];
        // input[i] = pivot;
        // input[start] = temp;

        swap(input, start, i);

        return i;

    }

    private int getRandomNumber(int start, int end) {
        Random rand = new Random();
        return rand.nextInt((end - start) + 1) + start;
    }

    private void swap(int[] input, int one, int two) {
        int temp = input[two];
        input[two] = input[one];
        input[one] = temp;
    }
}
