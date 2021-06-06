package pattern_based.searching_sorting.ik.part1_presort_transfrom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

 */

public class ThreeSum {

	public static void main(String[] args) {

		ThreeSum threeSum = new ThreeSum();

		int[] input1 = {-1, 0, 1, 2, -1, -4};
		System.out.println("Input1: " + threeSum.threeSum(input1));

		int[] input2 = {-2, 0, 0, 2, 2};
		System.out.println("Input1: " + threeSum.threeSum(input2));
	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> results = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0 || (i != 0 && nums[i] == nums[i - 1])) {
				continue;
			}
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int total = nums[i] + nums[start] + nums[end];
				if (total == 0) {

					Integer[] temp = {nums[i], nums[start], nums[end]};
					List<Integer> result = Arrays.asList(temp);
					results.add(result);
					start++;
					end--;
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}
				} else if (total < 0) {
					start++;
				} else {
					end--;
				}

			}

		}
		return results;
	}
}
