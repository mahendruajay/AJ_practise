package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumLevelSum {

    public static void main(String[] args) {

        MaximumLevelSum maximumLevelSum = new MaximumLevelSum();
        TreeNode rootBST = TreeUtils.BST();

        int result = maximumLevelSum.maxLevelSum(rootBST);
        System.out.println(result);


    }

    public int maxLevelSum(TreeNode root) {

        TreeNode node = root;
        int level = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int minLevel = 0;
        int maxTotal = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            level++;
            int total = 0;
            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                total += curr.value;
                if (total > maxTotal) {
                    maxTotal = total;
                    minLevel = level;
                }
            }
        }

        return minLevel;

    }
}
