package com.hackerrank.algorithms.track1;

import java.util.Scanner;

public class Challenge3 
{
	
	static void insertionSort(int[] ar) 
	{
		if(ar.length >= 1 && ar.length <1002)
		{
			int count = 0;
			for(int j=1; j< ar.length; j++)
			{
				int key = ar[j];
				int i = j-1;
			
				while( i >= 0 &&  ar[i] > key)
				{
					ar[i+1] = ar[i];
					i--;
					count++;
				}
				
				i=i+1;
				ar[i] = key;
			}
			System.out.println(count);
		}

    }

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		int[] array = {8,7,6,5,4,3,2,1};
//		Challenge3.insertionSort(array);
		
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
        {
           ar[i]=in.nextInt(); 
        }
        Challenge3.insertionSort(ar);

	}

}
