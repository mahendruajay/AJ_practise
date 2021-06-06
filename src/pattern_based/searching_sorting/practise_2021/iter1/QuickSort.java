package pattern_based.searching_sorting.practise_2021.iter1;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public void sort(int[] input){
        quickSortHelper(input,0, input.length-1);
    }

    public void quickSortHelper(int[] input, int start, int end){
        if(start < end){
            int mid = partition(input, start, end);
            quickSortHelper(input, start, mid-1);
            quickSortHelper(input, mid+1, end);
        }

    }

    private int partition(int[] input, int start, int end){
        int randomIndex = new Random().nextInt((end+1 - start)) + start;
        swap(input, start, randomIndex);
        int pivot = input[start];
        int small = start;
        int big = small+1;
        while(big <= end){
            if(input[big] < pivot){
                small++;
                swap(input, small, big);
            }
            big++;
        }
        swap(input, small, start);
        return small;
    }

    private void swap(int[] input, int first, int second){
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

    public static void main(String[] args) {
        int[] input = {10,5,2,8,5,1};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(input);

        System.out.println("Input: "+ Arrays.toString(input));
    }
}
