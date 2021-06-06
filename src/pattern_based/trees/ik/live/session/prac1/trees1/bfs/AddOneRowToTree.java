package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.Tree;
import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

/*
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth
depth. Note that the root node is at depth 1.

The adding rule is:
- Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val
as cur's left subtree root and right subtree root.
- cur's original left subtree should be the left subtree of the new left subtree root.
- cur's original right subtree should be the right subtree of the new right subtree root.
- If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root
of the whole original tree, and the original tree is the new root's left subtree.

 */

public class AddOneRowToTree {


    public static void main(String[] args) {

        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        TreeNode rootBST = TreeUtils.BST();

        TreeNode root = addOneRowToTree.addOneRow(rootBST, 2, 6);
        TreeUtils.printTree(root);

    }

    public TreeNode addOneRow(TreeNode root, int value, int depth) {
        if (depth == 1) { // root case
            TreeNode newNode = new TreeNode(value);
            newNode.left = root;
            root = newNode;
            return newNode;
        }

        TreeNode node = root;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int qLen = queue.size();

            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                if (level == depth - 1) {
                    TreeNode leftNode = new TreeNode(value);
                    leftNode.left = curr.left;
                    curr.left = leftNode;

                    TreeNode rightNode = new TreeNode(value);
                    rightNode.right = curr.right;
                    curr.right = rightNode;

                }
            }

            if (level == depth - 1) {
                return root;
            }
        }
        return root;
    }
}
