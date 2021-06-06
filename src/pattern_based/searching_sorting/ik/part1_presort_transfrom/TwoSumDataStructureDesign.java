package pattern_based.searching_sorting.ik.part1_presort_transfrom;

/*
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:

    TwoSum() Initializes the TwoSum object, with an empty array initially.
    void add(int number) Adds number to the data structure.
    boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.



Example 1:

Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Your TwoSumDataStructureDesign object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

public class TwoSumDataStructureDesign {

	private List<Integer> stream;
	private Map<Integer, List<Integer>> numMap;

	/**
	 * Initialize your data structure here.
	 */
	public TwoSumDataStructureDesign() {

		stream = new ArrayList<>();
		numMap = new HashMap<>();

	}

	public static void main(String[] args) {
		TwoSumDataStructureDesign twoSumDataStructureDesign = new TwoSumDataStructureDesign();
		twoSumDataStructureDesign.add(0);
		twoSumDataStructureDesign.add(0);
		twoSumDataStructureDesign.find(0);
	}

	/**
	 * Add the number to an internal data structure..
	 */
	public void add(int number) {
		stream.add(number);
		if (!numMap.containsKey(number)) {
			List<Integer> val = new ArrayList<>();
			numMap.put(number, val);
		}
		List<Integer> val = numMap.get(number);
		// Add index of num in the stream
		val.add(stream.size() - 1);
	}

	/**
	 * Find if there exists any pair of numbers which sum is equal to the value.
	 */
	public boolean find(int value) {
		for (int i = 0; i < stream.size(); i++) {
			int complement = value - stream.get(i);
			if (numMap.containsKey(complement)) {
				List<Integer> val = numMap.get(complement);
				int lastIndex = val.get(val.size() - 1);
				if (lastIndex != i) {
					return true;
				}
			}
		}
		return false;
	}
}
