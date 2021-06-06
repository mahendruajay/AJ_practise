package pattern_based.searching_sorting.practise_2021.iter1;

import java.util.Arrays;

public class CountingSort {


    public static void main(String[] args) {
        int[] input = {10, 5, 2, 8, 5, 1, 10, 9, 4, 2, 3};

        CountingSort countingSort = new CountingSort();
        countingSort.sort(input, 10);

    }

    public void sort(int[] input, int range) {

        System.out.println("Input: " + Arrays.toString(input));

        int[] output = new int[input.length];
        int[] rangeArray = new int[range + 1];


        for (int i = 0; i < input.length; i++) {
            rangeArray[input[i]] = rangeArray[input[i]] + 1;
        }

        for (int i = 1; i < rangeArray.length; i++) {
            rangeArray[i] = rangeArray[i - 1] + rangeArray[i];
        }

        for (int i = input.length - 1; i >= 0; i--) {
            output[rangeArray[input[i]] - 1] = input[i];
            rangeArray[input[i]] = rangeArray[input[i]] - 1;
        }

        System.out.println("Output: " + Arrays.toString(output));

    }
}
