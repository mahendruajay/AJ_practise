package pattern_based.searching_sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSort {

    private int[] input;
    private Map<Integer, Integer> inversionMap;

    public MergeSort(int[] input, Map<Integer, Integer> inversionMap) {
        this.input = input;
        this.inversionMap = inversionMap;
    }

    public static void main(String[] args) {
        int[] randomArray = new RandomArray(7).generateGivenBound(1, 10);

        System.out.println("Unsorted array is: ");
        for (int element : randomArray) {
            System.out.print(" " + element);
        }
        System.out.println();

        Map<Integer, Integer> inversionMap = new HashMap<>();
        MergeSort mergeSort = new MergeSort(randomArray, inversionMap);
        int[] output = mergeSort.sort();

        System.out.println("Sorted array is: ");
        for (int element : output) {
            System.out.print(" " + element);
        }
    }

    public int[] sort() {
        int low = 0;
        int high = input.length - 1;
        mergeSort(low, high);

        System.out.println("Inversion Map is: ");
        for (Map.Entry<Integer, Integer> entry : inversionMap.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }

        System.out.println();
        return Arrays.copyOf(input, input.length);
    }

    public void mergeSort(int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public void merge(int low, int mid, int high) {
        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];
        int inv_count = 0;

        int i = 0;
        for (int k = low; k <= mid; k++) {
            leftArray[i] = input[k];
            i++;
        }

        int j = 0;
        for (int k = mid + 1; k <= high; k++) {
            rightArray[j] = input[k];
            j++;
        }

        i = 0;
        j = 0;

        for (int k = low; k <= high; k++) {
            if (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] <= rightArray[j]) {
                    input[k] = leftArray[i];

                    if (null == inversionMap.get(leftArray[i])) {
                        inversionMap.put(leftArray[i], inv_count);
                    } else {
                        inversionMap.put(leftArray[i], inversionMap.get(leftArray[i]) + inv_count);
                    }

                    i++;
                } else {
                    input[k] = rightArray[j];
                    inv_count++;
                    j++;
                }
            } else if (i < leftArray.length) {
                input[k] = leftArray[i];
                if (null == inversionMap.get(leftArray[i])) {
                    inversionMap.put(leftArray[i], inv_count);
                } else {
                    inversionMap.put(leftArray[i], inversionMap.get(leftArray[i]) + inv_count);
                }
                i++;
            } else if (j < rightArray.length) {
                input[k] = rightArray[j];
                j++;
            }

        }

    }


}
