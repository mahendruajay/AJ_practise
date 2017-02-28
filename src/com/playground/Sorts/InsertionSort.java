package com.playground.Sorts;

public class InsertionSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();

        int[] arr = {5, 4, 3, 2, 1, 6};

        sort.insertionSort(arr);

        for (int item : arr) {
            System.out.print(item + " ");
        }

    }

    public void insertionSort(int[] input) {
        for (int j = 1; j < input.length; j++) {
            int key = input[j];
            int i = j - 1;

            while (i >= 0 && input[i] > key) {
                input[i + 1] = input[i];
                i--;
            }

            i = i + 1;
            input[i] = key;
        }
    }

}
