package playground.Sorts;

public class CountingSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CountingSort sort = new CountingSort();

        int[] arr = {0, 1, 0, 1, 0};

        int[] output = sort.countingSort(arr, 9);

        for (int item : output) {
            System.out.print(item + " ");
        }

    }

    public int[] countingSort(int[] input, int range) {
        int[] output = new int[input.length];
        int[] rangeArr = new int[range];

        for (int i = 0; i < input.length; i++) {
            rangeArr[input[i]] = rangeArr[input[i]] + 1;
        }

        for (int i = 1; i < rangeArr.length; i++) {
            rangeArr[i] = rangeArr[i] + rangeArr[i - 1];
        }

        for (int i = input.length - 1; i >= 0; i--) {
            output[rangeArr[input[i]] - 1] = input[i];

            rangeArr[input[i]] = rangeArr[input[i]] - 1;
        }

        return output;
    }

}
