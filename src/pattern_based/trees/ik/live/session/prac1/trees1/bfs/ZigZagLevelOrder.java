package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagLevelOrder {

    public static void main(String[] args) {

        ZigZagLevelOrder zigZagLevelOrder = new ZigZagLevelOrder();
        TreeNode rootBST = TreeUtils.BST();

        List<List<Integer>> result = zigZagLevelOrder.levelOrder(rootBST);
        System.out.println(result);

        result = zigZagLevelOrder.levelOrderUsingDeque(rootBST);
        System.out.println(result);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        boolean reversed = false;

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
            if (reversed) {
                Collections.reverse(temp);
            }
            results.add(temp);
            reversed = !reversed;
        }

        return results;
    }

    public List<List<Integer>> levelOrderUsingDeque(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        boolean reversed = false;

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            Deque<Integer> temp = new ArrayDeque<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (reversed) {
                    temp.addFirst(curr.value);
                } else {
                    temp.add(curr.value);
                }

            }

            results.add(temp.stream().collect(Collectors.toList()));
            reversed = !reversed;
        }

        return results;
    }
}
