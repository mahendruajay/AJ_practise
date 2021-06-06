package pattern_based.searching_sorting.ik.part3_partition_ext_qsort;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.


Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 */

import java.util.Random;

public class KthLargest {

	public static void main(String[] args) {

		KthLargest kthLargest = new KthLargest();
		int[] input = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		System.out.println("Result: " + kthLargest.findKthLargest(input, 1));
	}

	public int findKthLargest(int[] input, int kthLargest) {
		partitionHelper(input, 0, input.length - 1, input.length - kthLargest);
		return input[input.length - kthLargest];
	}

	public void partitionHelper(int[] input, int start, int end, int partIdx) {
		if (start > end) {
			return;
		}
		int partitionIndex = partition(input, start, end);

		if (partitionIndex == partIdx) {
			return;
		} else if (partitionIndex > partIdx) {
			partitionHelper(input, start, partitionIndex - 1, partIdx);
		} else {
			partitionHelper(input, partitionIndex + 1, end, partIdx);
		}
	}

	public int partition(int[] input, int start, int end) {
		int random = new Random().nextInt((end - start) + 1) + start;
		swap(input, start, random);
		int pivot = input[start];
		int i = start;
		int j = i + 1;
		while (j <= end) {
			if (input[j] < pivot) {
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
