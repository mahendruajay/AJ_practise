package pattern_based.trees.ik.live.session.prac1;

import java.util.ArrayDeque;
import java.util.Deque;

public class IterativeTreeTraversals {

    public static void main(String[] args) {
        IterativeTreeTraversals iterativeTreeTraversals = new IterativeTreeTraversals();
        TreeNode rootBST = TreeUtils.BST();

        iterativeTreeTraversals.iterativePreOrder(rootBST);
        System.out.println("Recursive PreOrder");
        iterativeTreeTraversals.recursivePreOrder(rootBST);

        iterativeTreeTraversals.iterativeInorder(rootBST);
        System.out.println("Recursive InOrder");
        iterativeTreeTraversals.recursiveInorder(rootBST);

        iterativeTreeTraversals.iterativePostorder(rootBST);
        System.out.println("Recursive PostOrder");
        iterativeTreeTraversals.recursivePostorder(rootBST);
    }

    public void recursivePreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            recursivePreOrder(root.left);
            recursivePreOrder(root.right);
        }
    }

    public void iterativePreOrder(TreeNode root) {

        System.out.println("\nIterative PreOrder");
        TreeNode node = root;

        Deque<StackNode> stack = new ArrayDeque<>();
        stack.push(new StackNode(node, NodeState.NONE));

        while (!stack.isEmpty()) {
            StackNode top = stack.peek();
            if (top.nodeState == NodeState.NONE) {
                top.nodeState = NodeState.ARRIVAL;
                System.out.print(top.treeNode.value + " ");
                if (top.treeNode.left != null) {
                    stack.push(new StackNode(top.treeNode.left, NodeState.NONE));
                }
            } else if (top.nodeState == NodeState.ARRIVAL) {
                top.nodeState = NodeState.INTERIM;
                if (top.treeNode.right != null) {
                    stack.push(new StackNode(top.treeNode.right, NodeState.NONE));
                }
            } else if (top.nodeState == NodeState.INTERIM) {
                top.nodeState = NodeState.DEPARTURE;
                stack.pop();
            }
        }

        System.out.println();

    }

    public void iterativeInorder(TreeNode root) {
        System.out.println("\n\nIterative InOrder");
        TreeNode node = root;


        Deque<StackNode> stack = new ArrayDeque<>();
        stack.push(new StackNode(node, NodeState.NONE));

        while (!stack.isEmpty()) {
            StackNode top = stack.peek();

            if (top.nodeState == NodeState.NONE) {
                top.nodeState = NodeState.ARRIVAL;
                if (top.treeNode.left != null) {
                    stack.push(new StackNode(top.treeNode.left, NodeState.NONE));
                }
            } else if (top.nodeState == NodeState.ARRIVAL) {
                top.nodeState = NodeState.INTERIM;
                System.out.print(top.treeNode.value + " ");
                if (top.treeNode.right != null) {
                    stack.push(new StackNode(top.treeNode.right, NodeState.NONE));
                }
            } else if (top.nodeState == NodeState.INTERIM) {
                top.nodeState = NodeState.DEPARTURE;
                stack.pop();
            }
        }
        System.out.println();
    }

    public void iterativePostorder(TreeNode root) {
        System.out.println("\n\nIterative PostOrder");
        TreeNode node = root;


        Deque<StackNode> stack = new ArrayDeque<>();
        stack.push(new StackNode(node, NodeState.NONE));

        while (!stack.isEmpty()) {
            StackNode top = stack.peek();

            if (top.nodeState == NodeState.NONE) {
                top.nodeState = NodeState.ARRIVAL;
                if (top.treeNode.left != null) {
                    stack.push(new StackNode(top.treeNode.left, NodeState.NONE));
                }
            } else if (top.nodeState == NodeState.ARRIVAL) {
                top.nodeState = NodeState.INTERIM;
                if (top.treeNode.right != null) {
                    stack.push(new StackNode(top.treeNode.right, NodeState.NONE));
                }
            } else if (top.nodeState == NodeState.INTERIM) {
                top.nodeState = NodeState.DEPARTURE;
                System.out.print(top.treeNode.value + " ");
                stack.pop();
            }
        }
        System.out.println();
    }

    public void recursiveInorder(TreeNode root) {
        if (root != null) {
            recursiveInorder(root.left);
            System.out.print(root.value + " ");
            recursiveInorder(root.right);
        }
    }

    public void recursivePostorder(TreeNode root) {
        if (root != null) {
            recursivePostorder(root.left);
            recursivePostorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    public enum NodeState {
        NONE, ARRIVAL, INTERIM, DEPARTURE
    }

    public class StackNode {
        TreeNode treeNode;
        NodeState nodeState;

        public StackNode(TreeNode treeNode, NodeState nodeState) {
            this.treeNode = treeNode;
            this.nodeState = nodeState;
        }
    }
}
