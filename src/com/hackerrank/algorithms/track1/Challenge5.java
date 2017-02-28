package com.hackerrank.algorithms.track1;

import java.util.ArrayList;
import java.util.List;

public class Challenge5 
{
	
	static void quickSort(int[] ar) 
	{
		int start=0;
		int end= ar.length-1;
		performQuickSort(ar, start, end);
		
		for(int element : ar)
		{
			System.out.print(element + " ");
		}
    }  
	
	static void performQuickSort(int[] array, int start, int end)
	{
		if(start < end)
		{
			int partition = partition(array, start, end);
			performQuickSort(array, start, partition-1);
			if((partition-1)-start >= 1)
			{
				for(int i = start; i<= partition-1; i++)
				{
					System.out.print(array[i] + " ");
				}
				System.out.println();
			}
			
			performQuickSort(array, partition+1, end);
			
			if(end - (partition+1) >= 1)
			{
				for(int i = partition+1; i<= end; i++)
				{
					System.out.print(array[i] + " ");
				}
				System.out.println();
			}
			
			
		}
	}
	
	
	static int partition(int[] ar, int start, int end) 
	{
		int partitionIndex = start;
		if(ar.length >=2 && ar.length < 1001)
		{
			int pivot = ar[start];
			
			List<Integer> low = new ArrayList<Integer>();
			List<Integer> high = new ArrayList<Integer>();
			
			for(int j=start+1; j<= end; j++)
			{
				if(ar[j] < pivot)
				{
					low.add(ar[j]);
				}
				else
				{
					high.add(ar[j]);
				}
			}
			
			int i =start;
			for(Integer lowInt: low)
			{
				ar[i] = lowInt;
				i++;
			}
			
			partitionIndex = start + low.size();
			ar[start+ low.size()] = pivot;
			
			i=start+low.size()+1;
			for(Integer highInt: high)
			{
				ar[i] = highInt;
				i++;
			}
			
		}

		return partitionIndex;
	}
	
//	static int partition(int[] array, int start, int end)
//	{
//		int pivot = array[start];
//		int i= start;
//		
//		for(int j=start+1; j<= end; j++)
//		{
//			if(array[j] < pivot)
//			{
//				i=i+1;
//				int temp = array[i];
//				array[i] = array[j];
//				array[j] = temp;
//			}
//		}
//		
//		array[start] = array[i];
//		array[i] = pivot;
//		
//		return i;
//		
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		int[] array = {5,8,1,3,7,9,2};
//		int[] array = {8,5};
		quickSort(array);

	}

}
