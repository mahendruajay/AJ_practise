package com.hackerrank.algorithms.track1;


public class Challenge2 
{
	
	
	
	static void insertionSort(int[] ar) 
	{
		if(ar.length >= 1 && ar.length <1001)
		{
			
			for(int j=1; j< ar.length; j++)
			{
				int key = ar[j];
				int i = j-1;
			
				while( i >= 0 &&  ar[i] > key)
				{
					ar[i+1] = ar[i];
					i--;
				}
				
				i=i+1;
				ar[i] = key;
				for(int arrayElement : ar)
				{
					System.out.print(arrayElement + " ");
				}
				System.out.println();
			
			}
		}

    }
	
	public static void main(String[] args)
	{
//		int[] array = new int[2];
//		
//		for(int i = 0; i<2; i++)
//		{
//			array[i] = i;
//		}
//		array[array.length-1] = 50;
		
		
		int[] array = {1,4,3,5,6,2};
		Challenge2.insertionSort(array);
		
//		 for(int n: array)
//         {
//            System.out.print(n+" ");
//         }
//           System.out.println("");
		
		
		
		
	       
	     
//	           Scanner in = new Scanner(System.in);
//	           int n = in.nextInt();
//	           int[] ar = new int[n];
//	           for(int i=0;i<n;i++)
//	           {
//	              ar[i]=in.nextInt(); 
//	           }
//	           insertionSort(ar);
	          
	}
}
