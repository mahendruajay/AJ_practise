package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BottomUpBinaryTreeLevelOrder {

    public static void main(String[] args) {

        BottomUpBinaryTreeLevelOrder bottomUpBinaryTreeLevelOrder = new BottomUpBinaryTreeLevelOrder();
        TreeNode rootBST = TreeUtils.BST();

        List<List<Integer>> result = bottomUpBinaryTreeLevelOrder.levelOrder(rootBST);
        System.out.println(result);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);

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

        Collections.reverse(result);
        return result;
    }
}
