package pattern_based.searching_sorting.ik;

import java.util.ArrayList;
import java.util.List;

/*
 Implement Merge Sort

Problem Statement: You are given an array of integers. You have to sort the array using merge sort algorithm.

 */

public class MergeSort {

    public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here
        return mergeSortHelper(arr, 0, arr.size()-1);

    }

    public static List<Integer> mergeSortHelper(List<Integer> arr, int start, int end)
    {
        if(start < end)
        {
            int mid = (start+end)/2;
            mergeSortHelper(arr, start, mid);
            mergeSortHelper(arr, mid+1, end);
            merge(arr, start, mid, end);
        }

        return arr;
    }

    public static List<Integer> merge(List<Integer> arr, int start, int mid, int end)
    {
        int listLeftSize = (mid-start) + 1;
        int listRightSize = end - mid;
        // System.out.println("start:" + start + " mid:" + mid + " end:" + end);
        // System.out.println("listLeftSize:"  + listLeftSize + ", listRightSize:" + listRightSize);

        List<Integer> listLeft = new ArrayList<>(listLeftSize);
        List<Integer> listRight = new ArrayList<>(listRightSize);
        for(int i =start; i<= mid; i++)
        {
            listLeft.add(arr.get(i));
        }

        for(int i = mid+1; i<= end; i++)
        {
            listRight.add(arr.get(i));
        }

        // System.out.println("listLeft:" + listLeft);
        // System.out.println("listRight:" + listRight);


        int i = 0;
        int j = 0;
        int k = start;

        while (i < listLeft.size() && j < listRight.size())
        {
            if(listLeft.get(i) <= listRight.get(j))
            {
                arr.set(k, listLeft.get(i)) ;
                i++;
            }
            else {
                arr.set(k, listRight.get(j));
                j++;
            }
            k++;
        }

        while (i < listLeft.size() )
        {
            arr.set(k, listLeft.get(i)) ;
            i++;
            k++;
        }
        while (j < listRight.size() )
        {
            arr.set(k, listRight.get(j));
            j++;
            k++;
        }
        // System.out.println("arr:" + arr);

        return arr;
    }
}
