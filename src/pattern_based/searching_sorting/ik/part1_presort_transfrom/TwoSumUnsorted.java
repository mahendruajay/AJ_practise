package pattern_based.searching_sorting.ik.part1_presort_transfrom;


/*
Two Sum problem I (Unsorted)
https://leetcode.com/problems/two-sum/
Given an array of unsorted integers, find two numbers/pairs of numbers that add up to a given number.

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoSumUnsorted {

	public static void main(String[] args) {
		int[] input1 = {2, 7, 11, 15};
		TwoSumUnsorted twoSumUnsorted = new TwoSumUnsorted();
		List<Result> results = twoSumUnsorted.twoSum(input1, 9);
		System.out.println("Results: " + results);

		int[] input2 = {3, 3};
		results = twoSumUnsorted.twoSum(input2, 3);
		System.out.println("Results: " + results);

		int[] input3 = {3, 7, 4, 5, 2, 0, 3, 0, 9, 7};
		results = twoSumUnsorted.twoSum(input3, 7);
		System.out.println("Results: " + results);
	}

	public List<Result> twoSum(int[] input, int target) {
		Map<Integer, List<Integer>> numIndex = new HashMap<>();
		List<Result> results = new ArrayList<>();

		for (int i = 0; i < input.length; i++) {
			int secondNum = target - input[i];
			if (numIndex.containsKey(secondNum)) {
				List<Integer> val = numIndex.get(secondNum);
				results.add(new Result(i, val.remove(val.size() - 1)));
				if (val.isEmpty()) {
					numIndex.remove(secondNum);
				}
			} else {

				List<Integer> val = new ArrayList<>();
				numIndex.put(input[i], val);
				numIndex.get(input[i]).add(i);

			}
		}

		return results;
	}

	public class Result {
		private int index1;
		private int index2;

		public Result(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}

		@Override
		public String toString() {
			return "Result{" +
					"index1=" + index1 +
					", index2=" + index2 +
					'}';
		}
	}
}
