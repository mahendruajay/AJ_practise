package pattern_based.searching_sorting;

public class InsertionSort {

    private int[] input;

    public InsertionSort(int[] input) {
        this.input = input;
    }

    public static void main(String[] args) {
//        int[] input = new RandomArray(0).generateArrayBound();
//        int[] input = new RandomArray(10).generateAnyInt();
        int[] input = new RandomArray(1).generateGivenBound(100, 137);
        InsertionSort insertionSort = new InsertionSort(input);

        int[] output = insertionSort.sort();

        for (int element : output) {
            System.out.println(element);
        }
    }

    public int[] sort() {
        return insertionSort();
    }

    private int[] insertionSort() {
        for (int j = 1; j < input.length; j++) {
            int key = input[j];
            int i = j - 1;
            while (i >= 0 && input[i] > key) {
                input[i + 1] = input[i];
                i--;
            }
            input[i + 1] = key;
        }

        return input;
    }
}

