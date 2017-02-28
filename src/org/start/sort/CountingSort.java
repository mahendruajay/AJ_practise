package org.start.sort;

public class CountingSort implements Sort {

    private int[] input;
    private int range;

    public CountingSort(int[] input, int range) {
        this.input = input;
        this.range = range;
    }

    public int[] sort() {
        return countingSort();
    }

    public int[] countingSort() {
        int[] output = new int[input.length];
        int[] countingArray = new int[range];

        for (int i = 0; i < input.length; i++) {
            countingArray[input[i]]++;
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];

        }

        for (int i = input.length - 1; i >= 0; i--) {
            output[countingArray[input[i]] - 1] = input[i];
            countingArray[input[i]]--;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] randomArray = new RandomArray(5).generateGivenBound(5, 11);

        int[] output = new CountingSort(randomArray, 11).sort();

        for (int element : output) {
            System.out.println(element);
        }
    }

}
