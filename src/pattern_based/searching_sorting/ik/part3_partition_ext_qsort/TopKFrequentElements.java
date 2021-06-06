package pattern_based.searching_sorting.ik.part3_partition_ext_qsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

 */

public class TopKFrequentElements {
	Map<Integer, Integer> freq = new HashMap<>();

	public static void main(String[] args) {
		int[] input = {2, 3, 5, 1, 2, 1, 3, 3, 4, 1, 5, 6};

		TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
		System.out.println("Result: " + Arrays.toString(topKFrequentElements.findTopKFrequentElements(input, 6)));
	}

	public int[] findTopKFrequentElements(int[] input, int topK) {
		for (int num : input) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}

		int[] uniqueNums = freq.keySet().stream().mapToInt(Integer::intValue).toArray();

		quickSelect(uniqueNums, 0, uniqueNums.length - 1, uniqueNums.length - topK);
		return Arrays.copyOfRange(uniqueNums, uniqueNums.length - topK, uniqueNums.length);
	}

	public void quickSelect(int[] input, int start, int end, int partIdx) {
		if (start > end) {
			return;
		}
		int partitionIndex = partition(input, start, end);
		if (partitionIndex == partIdx) {
			return;
		} else if (partitionIndex > partIdx) {
			quickSelect(input, start, partitionIndex - 1, partIdx);
		} else {
			quickSelect(input, partitionIndex + 1, end, partIdx);
		}
	}

	public int partition(int[] input, int start, int end) {
		int randIdx = new Random().nextInt((end - start) + 1) + start;
		swap(input, start, randIdx);
		int pivot = freq.get(input[start]);
		int i = start;
		int j = i + 1;
		while (j <= end) {
			if (freq.get(input[j]) < pivot) {
				i = i + 1;
				swap(input, i, j);
			}
			j++;
		}
		swap(input, start, i);
		return i;
	}

	public void swap(int[] input, int first, int second) {
		int temp = input[first];
		input[first] = input[second];
		input[second] = temp;
	}

}
