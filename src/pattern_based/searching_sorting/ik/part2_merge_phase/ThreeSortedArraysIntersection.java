package pattern_based.searching_sorting.ik.part2_merge_phase;


/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the
integers that appeared in all three arrays.

Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.

Example 2:

Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []

 */

import java.util.*;

public class ThreeSortedArraysIntersection {

	public static void main(String[] args) {

		int[] arr1 = {1, 2, 2, 3, 4, 2, 5, 6, 6};
		int[] arr2 = {2, 4, 5};
		int[] arr3 = {4, 6, 5};

		ThreeSortedArraysIntersection threeSortedArraysIntersection = new ThreeSortedArraysIntersection();
		System.out.println("Results: " + threeSortedArraysIntersection.arraysIntersection(arr1, arr2, arr3));

	}

	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

		Map<Integer, Integer> freq = new TreeMap<>();

		List<Integer> results = new ArrayList<>();

		addArrayToFreq(freq, arr1);
		addArrayToFreq(freq, arr2);
		addArrayToFreq(freq, arr3);

		for (int key : freq.keySet()) {
			if (freq.get(key) == 3) {
				results.add(key);
			}
		}

		return results;


	}

	public void addArrayToFreq(Map<Integer, Integer> freq, int[] arr) {
		for (int num : arr) {
			if (!freq.containsKey(num)) {
				freq.put(num, 1);
			} else {
				freq.computeIfPresent(num, (k, v) -> v + 1);
			}

		}
	}
}
