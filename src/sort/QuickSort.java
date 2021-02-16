package sort;

import java.util.Random;

public class QuickSort implements Sort {

    private int[] input;

    public QuickSort(int[] input) {
        this.input = input;
    }

    @Override
    public int[] sort() {
        quicksort(0, input.length - 1);
        return input;
    }

    private void quicksort(int low, int high) {

        if (low < high) {
            int pivot = randomizePivot(low, high);
            quicksort(low, pivot - 1);
            quicksort(pivot + 1, high);

        }


    }


    private int randomizePivot(int low, int high) {

        Random random = new Random();
        int randomPivot = random.nextInt(high - low) + low;
        swap(low, randomPivot);

        int pivotNumber = input[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (input[j] < pivotNumber) {
                i = i + 1;
                swap(i, j);

            }
        }
        swap(low, i);

        return i;
    }

    private void swap(int some, int other) {
        int temp = input[some];
        input[some] = input[other];
        input[other] = temp;
    }

    public static void main(String[] args) {
        int[] randomArray = new RandomArray(6).generateGivenBound(1, 19);
        QuickSort quickSort = new QuickSort(randomArray);
        int[] output = quickSort.sort();

        for (int element : output) {
            System.out.println(element);
        }

    }


}
