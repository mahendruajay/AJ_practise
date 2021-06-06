package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthBinaryTree {

    public static void main(String[] args) {

        MaxWidthBinaryTree maxWidthBinaryTree = new MaxWidthBinaryTree();
        TreeNode rootBST = TreeUtils.BST();

        int maxWidth = maxWidthBinaryTree.maxWidth(rootBST);
        System.out.println("Max Width: " + maxWidth);

    }

    public int maxWidth(TreeNode root) {
        TreeNode node = root;

        Deque<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(node, 1));
        int level = 0;
        int maxWidth = Integer.MIN_VALUE;


        while (!queue.isEmpty()) {
            level++;
            int qLen = queue.size();
            int leftMost = 0;
            int rightMost = 0;

            for (int i = 0; i < qLen; i++) {
                QueueNode curr = queue.poll();
                if (curr.node.left != null) {
                    queue.offer(new QueueNode(curr.node.left, 2 * curr.id));
                }
                if (curr.node.right != null) {
                    queue.offer(new QueueNode(curr.node.right, 2 * curr.id + 1));
                }
                if (leftMost == 0) {
                    leftMost = curr.id;
                }
                rightMost = curr.id;
            }
            int width = rightMost - leftMost + 1;
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    public class QueueNode {
        TreeNode node;
        int id;

        public QueueNode(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
}

