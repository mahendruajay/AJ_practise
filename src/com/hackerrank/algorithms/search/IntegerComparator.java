package com.hackerrank.algorithms.search;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> 
{

	@Override
	public int compare(Integer one, Integer two) 
	{
		return two.compareTo(one);
	}

}
