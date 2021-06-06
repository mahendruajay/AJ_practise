package pattern_based.trees.ik.live.session.prac1.trees1.bfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AverageOfEachLevel {
    public static void main(String[] args) {

        AverageOfEachLevel averageOfEachLevel = new AverageOfEachLevel();
        TreeNode rootBST = TreeUtils.BST();

        List<Double> result = averageOfEachLevel.average(rootBST);
        System.out.println(result);
    }

    public List<Double> average(TreeNode root) {
        TreeNode node = root;
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            double total = 0;
            for (int i = 0; i < qLen; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                total += curr.value;
            }
            result.add(total / qLen);
        }
        return result;
    }
}
