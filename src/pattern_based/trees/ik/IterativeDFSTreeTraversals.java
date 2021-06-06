package pattern_based.trees.ik;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IterativeDFSTreeTraversals {

    public static void main(String[] args) {
        Tree tree = new Tree(new int[]{6, 10, 3, 4, 2, 7, 11, 1, 5, 8, 12});
        tree.bfsUsingQueue();

        IterativeDFSTreeTraversals iterativeDFSTreeTraversals = new IterativeDFSTreeTraversals();

        System.out.println("Iterative PreOrder: ");
        List<TreeNode> result = iterativeDFSTreeTraversals.iterativePreOrder(tree.getRoot());
        System.out.println(result);

        System.out.println("Iterative PostOrder: ");
        result = iterativeDFSTreeTraversals.iterativePostOrder(tree.getRoot());
        System.out.println(result);

        System.out.println("Iterative InOrder: ");
        result = iterativeDFSTreeTraversals.iterativeInOrder(tree.getRoot());
        System.out.println(result);

    }

    /*
     Iterative PreOrder is the simplest of all iterative traversals.
     It only involves one stack and pushing right node first and then left.
     */
    public List<TreeNode> iterativePreOrder(TreeNode root) {

        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node);

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        return result;
    }

    /*
        For Post order trick is to use two stacks. Imagine a balanced tree with three nodes. The root will always be printed at the last.
            6
         3    10

         In this case 6 should be printed last. PostOrder is: 3, 10, 6
         So always put the root in the first stack. When the top element (root is popped) put it in another second stack,
         the second stack is the one in which the root will be the last. Hence at the end the elements in second stack
         will gives us the post order.

     */
    public List<TreeNode> iterativePostOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
            stack2.push(node);
        }

        return new ArrayList<>(stack2);
    }

    public List<TreeNode> iterativeInOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode n = root;
        while (true) {
            if (n != null) {
                stack.push(n);
                n = n.getLeft();
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                n = stack.pop();
                result.add(n);
                n = n.getRight();
            }
        }

        return result;
    }

}
