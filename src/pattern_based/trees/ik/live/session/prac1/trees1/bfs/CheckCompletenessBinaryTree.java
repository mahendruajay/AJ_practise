package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

public class CheckCompletenessBinaryTree {

    public static void main(String[] args) {

        CheckCompletenessBinaryTree checkCompletenessBinaryTree = new CheckCompletenessBinaryTree();
        TreeNode rootBST = TreeUtils.BST();

        boolean checkCompleteness = checkCompletenessBinaryTree.checkCompleteness(rootBST);
        System.out.println("Check Completeness: " + checkCompleteness);

    }

    public boolean checkCompleteness(TreeNode root) {
        TreeNode node = root;

        Deque<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(node, 1));
        int expectedId = 1;

        while (!queue.isEmpty()) {
            int qLen = queue.size();

            for (int i = 0; i < qLen; i++) {
                QueueNode curr = queue.poll();
                if (curr.id != expectedId + i) {
                    return false;
                }
                if (curr.node.left != null) {
                    queue.offer(new QueueNode(curr.node.left, 2 * curr.id));
                }
                if (curr.node.right != null) {
                    queue.offer(new QueueNode(curr.node.right, 2 * curr.id + 1));
                }
            }
            expectedId = expectedId * 2;

        }

        return true;
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