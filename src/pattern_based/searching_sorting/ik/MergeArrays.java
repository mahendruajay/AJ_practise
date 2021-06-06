package pattern_based.searching_sorting.ik;

/*
Merge One Sorted Array Into Another

Given two arrays:

1) arr1 of size n, which contains n positive integers sorted in the ascending order.
2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).

Write a function that takes these two arrays, and merges the first one into second one,
resulting in an increasingly sorted array of (2*n) positive integers.

Example

Input:

arr1 = [1 3 5]
arr2 = [2 4 6 0 0 0]

Output: arr2 = [1 2 3 4 5 6]

 */

public class MergeArrays {

    public static void main(String args[]){
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2,4,6,0,0,0};
        merger_first_into_second(arr1, arr2);

    }

    /*
     * Complete the merger_first_into_second function below.
     */
    static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */


        int i = arr1.length-1;
        int j = (arr2.length/2)-1;

        int k = arr2.length-1;

        while (i >= 0 && j >= 0){
            if(arr1[i] >= arr2[j]){
                arr2[k] = arr1[i];
                i--;
            }
            else {
                arr2[k] = arr2[j];
                j--;
            }
            k--;
        }

        while (i >=0 ){
            arr2[k] = arr1[i];
            i--;
            k--;
        }
        while (j >=0 ){
            arr2[k] = arr2[j];
            j--;
            k--;
        }

    }
}
