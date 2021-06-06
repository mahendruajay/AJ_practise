package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinimumDepth {

    public static void main(String[] args) {

        MinimumDepth minimumDepth = new MinimumDepth();
        TreeNode rootBST = TreeUtils.BST();

        int result = minimumDepth.minDepth(rootBST);
        System.out.println(result);


    }

    public int minDepth(TreeNode root) {

        TreeNode node = root;
        int level = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            level++;
            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (curr.left == null && curr.right == null) {
                    return level;
                }
            }
        }
        return level;
    }
}
