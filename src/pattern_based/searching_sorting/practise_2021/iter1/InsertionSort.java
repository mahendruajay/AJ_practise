package pattern_based.searching_sorting.practise_2021.iter1;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] input){

        for(int i=1; i< input.length; i++){

            int curr = input[i];
            int j = i-1;

            while(j >= 0 && curr < input[j]){
                input[j+1] = input[j];
                j--;
            }

            input[j+1] = curr;

        }

    }


    public void swap(int[] input, int first, int second){
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

    public static void main(String[] args) {

        int[] input = {10,5,2,8,5,1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(input);

        System.out.println("input = " + Arrays.toString(input));

    }

}
