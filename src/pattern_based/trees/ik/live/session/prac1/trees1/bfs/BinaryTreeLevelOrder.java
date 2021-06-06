package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder {

    public static void main(String[] args) {

        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        TreeNode rootBST = TreeUtils.BST();

        List<List<Integer>> result = binaryTreeLevelOrder.levelOrder(rootBST);
        System.out.println(result);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        TreeNode node = root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                temp.add(curr.value);
            }
            result.add(temp);
        }

        return result;
    }
}
