package pattern_based.trees.ik.live.session.prac1.trees2.dfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;


/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
adding up all the values along the path equals targetSum.

 */

public class PathSum {

    public static void main(String[] args) {

        PathSum pathSum = new PathSum();
        TreeNode rootBST = TreeUtils.BST();

        PathSumResult pathSumResult = new PathSum.PathSumResult(false);

        pathSum.isPathSum(rootBST, 195, pathSumResult);
        System.out.println("Result: " + pathSumResult.result);

        pathSumResult.result = false;

        pathSum.isPathSum(rootBST, 350, pathSumResult);
        System.out.println("Result: " + pathSumResult.result);

    }

    public void isPathSum(TreeNode root, int target, PathSumResult pathSumResult) {
        // leaf
        if (root.left == null && root.right == null) {
            target = target - root.value;
            if (target == 0) {
                pathSumResult.result = true;
            }

        }
        if (root.left != null) {
            isPathSum(root.left, target - root.value, pathSumResult);
        }

        if (root.right != null) {
            isPathSum(root.right, target - root.value, pathSumResult);
        }
    }

    public static class PathSumResult {
        boolean result;

        public PathSumResult(boolean result) {
            this.result = result;
        }
    }
}
