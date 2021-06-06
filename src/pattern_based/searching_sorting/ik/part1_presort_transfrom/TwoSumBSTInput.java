package pattern_based.searching_sorting.ik.part1_presort_transfrom;

import cracking.coding.interview.graphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such
that their sum is equal to the given target.

Example 1:

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

 */

public class TwoSumBSTInput {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> sortedTree = new ArrayList<>();
		inorder(root, sortedTree);

		Integer[] numbers = sortedTree.toArray(new Integer[0]);

		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			if (numbers[start] + numbers[end] == k) {
				return true;
			} else if (numbers[start] + numbers[end] < k) {
				start++;
			} else {
				end--;
			}
		}

		return false;

	}

	public void inorder(TreeNode root, List<Integer> sortedTree) {
		if (null != root) {
			inorder(root.getLeft(), sortedTree);
			sortedTree.add(root.getData());
			inorder(root.getRight(), sortedTree);
		}
	}
}
