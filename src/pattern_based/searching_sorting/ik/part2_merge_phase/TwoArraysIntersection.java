package pattern_based.searching_sorting.ik.part2_merge_phase;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

 */

import java.util.*;

public class TwoArraysIntersection {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};

		TwoArraysIntersection twoArraysIntersection = new TwoArraysIntersection();
		twoArraysIntersection.intersection(nums1, nums2);

		System.out.println("Result: " + Arrays.toString(twoArraysIntersection.intersection(nums1, nums2)));


	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> temp = new HashSet<>();
		Set<Integer> result = new HashSet<>();

		int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
		int[] bigger = nums1.length > nums2.length ? nums1 : nums2;

		for (int num : smaller) {
			temp.add(num);
		}

		for (int num : bigger) {
			if (temp.contains(num)) {
				result.add(num);
			}
		}

		int[] ints = result.stream().mapToInt(Integer::intValue).toArray();


		return ints;
	}
}
