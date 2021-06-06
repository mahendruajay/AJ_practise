package pattern_based.trees.ik.live.session.prac1.trees2.dfs;

import pattern_based.trees.ik.live.session.prac1.TreeNode;
import pattern_based.trees.ik.live.session.prac1.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

    public static void main(String[] args) {

        PrintAllPaths printAllPaths = new PrintAllPaths();
        TreeNode rootBST = TreeUtils.BST();

        List<List<Integer>> results = new ArrayList<>();

        printAllPaths.printAllPaths(rootBST, new ArrayList<>(), results);
        System.out.println("Result: " + results);

    }

    public void printAllPaths(TreeNode root, List<Integer> slate, List<List<Integer>> results) {
        // leaf
        if (root.left == null && root.right == null) {
            slate.add(root.value);
            results.add(new ArrayList<>(slate));
            slate.remove(slate.size() - 1);
        }

        if (root.left != null) {
            slate.add(root.value);
            printAllPaths(root.left, slate, results);
            slate.remove(slate.size() - 1);
        }

        if (root.right != null) {
            slate.add(root.value);
            printAllPaths(root.right, slate, results);
            slate.remove(slate.size() - 1);
        }

    }
}
