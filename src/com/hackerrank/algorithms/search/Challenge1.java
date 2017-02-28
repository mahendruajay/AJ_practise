package com.hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge1 
{
    
	
	
	public static void countNumbers(int[] elements, int diff)
	{
		Arrays.sort(elements);
		
		int big = elements.length-1;
		int runner = big-1;
		int count=0;
		
		while(big >= 0 && runner >= 0)
		{
			int difference = elements[big] - elements[runner];
			if(difference < diff)
			{
				runner--;
			}
			else if(difference > diff)
			{
				big--;
			}
			else if(difference == diff)
			{
				count++;
				big--;
				runner--;
			}
		}
		
		System.out.println(count);
		
	}
	
	
	public static void main(String[] args) 
    {
        Scanner inScanner = new Scanner(System.in);
        
        int numberOfElements = inScanner.nextInt();
        int diff = inScanner.nextInt();
        int[] elements = new int[numberOfElements];
        
        for(int i=0; i< numberOfElements; i++)
        {
        	elements[i] = inScanner.nextInt();
        }
        
        countNumbers(elements, diff);
    }
	
	
}
