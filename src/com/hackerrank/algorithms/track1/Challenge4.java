package com.hackerrank.algorithms.track1;

import java.util.ArrayList;
import java.util.List;

public class Challenge4 
{

	
	static void partition(int[] ar) 
	{
		if(ar.length >=2 && ar.length < 1001)
		{
			int pivot = ar[0];
			
			List<Integer> low = new ArrayList<Integer>();
			List<Integer> high = new ArrayList<Integer>();
			
			for(int j=1; j< ar.length; j++)
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
			
			int i =0;
			for(Integer lowInt: low)
			{
				ar[i] = lowInt;
				i++;
			}
			ar[low.size()] = pivot;
			
			i=low.size()+1;
			for(Integer highInt: high)
			{
				ar[i] = highInt;
				i++;
			}
			
			for(int element : ar)
			{
				System.out.print(element + " ");
			}
			
		}
		if(ar.length ==1)
		{
			System.out.print(ar[0]);
		}
		
        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] array = {1,2,3};
		partition(array);

	}

}
