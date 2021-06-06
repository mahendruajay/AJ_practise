package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

public class CousinsInBinaryTree {

    public static void main(String[] args) {

        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        TreeNode rootBST = TreeUtils.BST();

        boolean result = cousinsInBinaryTree.cousins(rootBST, 30, 90);
        System.out.println("X: " + 30 + " Y: " + 90 + " Result: " + result);

        result = cousinsInBinaryTree.cousins(rootBST, 40, 90);
        System.out.println("X: " + 40 + " Y: " + 90 + " Result: " + result);

        result = cousinsInBinaryTree.cousins(rootBST, 20, 100);
        System.out.println("X: " + 20 + " Y: " + 100 + " Result: " + result);

    }

    public boolean cousins(TreeNode root, int x, int y) {

        TreeNode node = root;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode parentX = null;
        TreeNode parentY = null;
        while (!queue.isEmpty()) {
            int qLen = queue.size();

            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (curr.left != null && curr.left.value == x) {
                    parentX = curr;
                }

                if (curr.left != null && curr.left.value == y) {
                    parentY = curr;
                }

                if (curr.right != null && curr.right.value == x) {
                    parentX = curr;
                }

                if (curr.right != null && curr.right.value == y) {
                    parentY = curr;
                }

            }

            if ((parentX == null && parentY != null) || (parentX != null && parentY == null)) {
                return false;
            }
            if (parentX != null && parentY != null) {
                return parentX.value != parentY.value;
            }
        }

        return false;
    }
}
