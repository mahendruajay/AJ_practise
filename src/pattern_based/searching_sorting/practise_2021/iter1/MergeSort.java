package pattern_based.searching_sorting.practise_2021.iter1;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] input){
        int start = 0;
        int end = input.length-1;
        mergeSortHelper(input, start, end);
    }

    private void mergeSortHelper(int[] input , int start, int end){
        if(start < end){
            int mid = (end-start)/2 + start;
            mergeSortHelper(input, start, mid);
            mergeSortHelper(input,mid+1, end);
            merge(input, start, mid, end);
        }

    }

    private void merge(int[] input, int start, int mid, int end){
//        int[] left = new int[mid-start+1];
//        int[] right = new int[end-mid];

        int[] aux = Arrays.copyOf(input, input.length);
        System.out.println("Before merge aux = " + Arrays.toString(aux));

        int left = start;
        int left_end = mid;

        int right = mid+1;
        int right_end = end;


        int k = start;

        while(left <= left_end && right <= right_end ){
            if(aux[left] <= aux[right]){
                input[k] = aux[left];
                left++;
            }
            else{
                input[k] = aux[right];
                right++;
            }
            k++;
        }

        while(left <= left_end){
            input[k] = aux[left];
            k++;
            left++;
        }

        while(right < right_end){
            input[k] = aux[right];
            k++;
            right++;
        }

        System.out.println("After merge input = " + Arrays.toString(input));


    }

    public static void main(String[] args) {

        int[] input = {10,5,2,8,5,1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);
        System.out.println("input = " + Arrays.toString(input));

    }
}
