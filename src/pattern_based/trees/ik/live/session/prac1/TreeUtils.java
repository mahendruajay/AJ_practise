package pattern_based.trees.ik.live.session.prac1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeUtils {

    public static int[] INPUT = new int[]{10, 20, 30, 40, 60, 65, 70, 80, 90, 95, 100};

    public static TreeNode buildBST(int[] input) {
        Arrays.sort(input);

        TreeNode root = buildBSTHelper(input, 0, input.length - 1);
        return root;
    }

    public static TreeNode buildBinaryTree(int[] input) {
        List<Integer> inp = IntStream.of(input).boxed().collect(Collectors.toList());
        Collections.shuffle(inp);
        input = inp.stream().mapToInt(Integer::intValue).toArray();

        TreeNode root = buildBSTHelper(input, 0, input.length - 1);
        return root;
    }

    public static TreeNode buildBSTHelper(int[] input, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = (end - start) / 2 + start;
            TreeNode node = new TreeNode(input[mid]);
            node.left = buildBSTHelper(input, start, mid - 1);
            node.right = buildBSTHelper(input, mid + 1, end);
            return node;
        }

    }

    public static TreeNode BST() {
        TreeNode root = TreeUtils.buildBST(INPUT);
        TreeUtils.printTree(root);

        return root;
    }

    public static TreeNode BinaryTree() {
        TreeNode root = TreeUtils.buildBinaryTree(INPUT);
        TreeUtils.printTree(root);

        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = TreeUtils.buildBST(new int[]{10, 20, 30, 40, 60, 65, 70, 80, 90, 95, 100});
        TreeNode root = TreeUtils.buildBST(INPUT);
        TreeUtils.printTree(root);

//        root = TreeUtils.buildBinaryTree(new int[]{10, 20, 30, 40, 60, 65, 70, 80, 90, 95, 100});
        root = TreeUtils.buildBinaryTree(INPUT);
        TreeUtils.printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (null == root) {
            System.out.println("Empty Tree");
        }
        System.out.println("Tree is: ");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                if (null != node) {
                    System.out.print(node.value + " ");
                } else {
                    System.out.print("null ");
                }

                if (node != null) {
                    queue.offer(node.left);
                }
                if (node != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
        System.out.println();

    }

}
