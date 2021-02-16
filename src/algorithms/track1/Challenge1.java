package algorithms.track1;

import java.util.Scanner;

public class Challenge1 
{
	static void insertionSort(int[] ar) 
	{
		if(ar.length >= 1 && ar.length <1001)
		{
			int key = ar[ar.length-1];
			int i= ar.length-2;
			
			while( i >= 0 &&  ar[i] > key)
			{
				ar[i+1] = ar[i];
				
				for(int arrayElement : ar)
				{
					System.out.print(arrayElement + " ");
				}
				System.out.println();
				i--;
			}
			
			i=i+1;
			ar[i] = key;
			
			
			for(int arrayElement : ar)
			{
				System.out.print(arrayElement + " ");
			}
		}
		if(ar.length == 1)
		{
			System.out.print(ar[0]);
		}
    }
	
	 static void printArray(int[] ar) 
	 {
         for(int n: ar)
         {
            System.out.print(n+" ");
         }
           System.out.println("");
      }
	
	public static void main(String[] args)
	{
		int[] array = new int[1];
		
		for(int i = 0; i<1; i++)
		{
			array[i] = i;
		}
		array[array.length-1] = 50;
		Challenge1.insertionSort(array);
		
//		 for(int n: array)
//         {
//            System.out.print(n+" ");
//         }
//           System.out.println("");
		
		
		
		
	       
	     
	           Scanner in = new Scanner(System.in);
	           int n = in.nextInt();
	           int[] ar = new int[n];
	           for(int i=0;i<n;i++)
	           {
	              ar[i]=in.nextInt(); 
	           }
	           insertionSort(ar);
	          
	}
}
