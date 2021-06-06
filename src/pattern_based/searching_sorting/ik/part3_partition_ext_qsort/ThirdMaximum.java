package pattern_based.searching_sorting.ik.part3_partition_ext_qsort;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.



Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.

Example 2:

Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 */
public class ThirdMaximum {

	public static void main(String[] args) {
		int[] input = {2, 2};
		ThirdMaximum thirdMaximum = new ThirdMaximum();
		System.out.println("Result: " + thirdMaximum.findThirdMax(input));
	}

	public int findThirdMax(int[] input) {
		Set<Integer> threeMaxNums = new HashSet<>();


		for (int num : input) {
			threeMaxNums.add(num);
			if (threeMaxNums.size() > 3) {
				threeMaxNums.remove(Collections.min(threeMaxNums));
			}
		}
		if (threeMaxNums.size() < 3) {
			return Collections.max(threeMaxNums);
		}

		return Collections.min(threeMaxNums);

	}
}
