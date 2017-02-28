package org.start.tress.and.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class Tree {

    private TreeNode root;
    private int index;

//    public Tree()
//    {
//
//    }

    public Tree(int[] data) {
        for (int d : data) {
            insert(d);
        }
    }

    public void insert(int data) {

        TreeNode node = new TreeNode(data);
        if (null == root) {
            root = node;
        } else {

            root.insert(node);
        }
    }

    public TreeNode commonAncestorSibling(TreeNode node1, TreeNode node2) {
        TreeNode root1 = root;
        if (!root1.covers(node1) || !root1.covers(node2)) {
            return null;
        }
        if (node1.covers(node2)) {
            return node1;
        }
        if (node2.covers(node1)) {
            return node2;
        }
        TreeNode sibling = node1.getSibling();
        TreeNode parent = node1.getParent();
        while (null != sibling && !sibling.covers(node2)) {
            sibling = parent.getSibling();
            parent = parent.getParent();
        }
        return parent;

    }

    public int pathsWithSum(int targetSum) {
        TreeNode n = root;
        Map<Integer, Integer> paths = new HashMap<>();
        return pathsWithSumRec(n, targetSum, 0, paths);

    }

    private int pathsWithSumRec(TreeNode root, int targetSum, int runningSum, Map<Integer, Integer> paths) {
        if (root == null) {
            return 0;
        }

        runningSum += root.getData();
        int delta = runningSum - targetSum;

        int totalPaths = paths.getOrDefault(delta, 0);

        if (runningSum == targetSum) {
            totalPaths++;
        }

        updatePaths(paths, runningSum, 1);
        totalPaths += pathsWithSumRec(root.getLeft(), targetSum, runningSum, paths);
        totalPaths += pathsWithSumRec(root.getRight(), targetSum, runningSum, paths);
        updatePaths(paths, runningSum, -1);

        return totalPaths;

    }

    private void updatePaths(Map<Integer, Integer> paths, int key, int value) {
        int newCount = paths.getOrDefault(key, 0) + value;
        if (newCount == 0) {
            paths.remove(key);
        } else {
            paths.put(key, newCount);
        }

    }


    public List<List<TreeNode>> getLevelLists() {
        TreeNode n = root;
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        if (n != null) {
            current.add(n);
        }

        while (!current.isEmpty()) {
            result.add(current);
            List<TreeNode> parents = current;
            current = new ArrayList<>();
            for (TreeNode node : parents) {
                if (null != node.getLeft()) {
                    current.add(node.getLeft());
                }
                if (null != node.getRight()) {
                    current.add(node.getRight());
                }
            }
        }

        return result;

    }

    public void printLevelsSpiral() {

        TreeNode n = root;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(null);
        dq.offerFirst(n);
        while (null != dq.peekFirst() || null != dq.peekLast()) {
            while (dq.peekFirst() != null) {
                TreeNode node = dq.pollFirst();
                System.out.print(node.getData() + ", ");
                if (node.getLeft() != null) {
                    dq.offerLast(node.getLeft());
                }
                if (node.getRight() != null) {
                    dq.offerLast(node.getRight());
                }

            }
            while (dq.peekLast() != null) {
                TreeNode node = dq.pollLast();
                System.out.print(node.getData() + ", ");
                if (node.getRight() != null) {
                    dq.offerFirst(node.getRight());
                }
                if (node.getLeft() != null) {
                    dq.offerFirst(node.getLeft());
                }

            }

        }

    }

    public void printLevelsUsingQueueAndCounters() {
        TreeNode n = root;
        Deque<TreeNode> nodes = new LinkedList<>();
        int level = 0;
        int currentCount = 0;
        TreeNode current = null;

        nodes.offer(n);
        level = 1;

        while (!nodes.isEmpty()) {
            current = nodes.poll();
            if (current.getLeft() != null) {
                nodes.offer(current.getLeft());
                currentCount++;
            }
            if (current.getRight() != null) {
                nodes.offer(current.getRight());
                currentCount++;
            }
            System.out.print(current.getData() + " ");
            level--;
            if (level == 0) {
                System.out.println();
                level = currentCount;
                currentCount = 0;
            }
        }

        System.out.println();

    }

    public void printLevelsUsingQueueAndDelimiter() {
        TreeNode n = root;
        Deque<TreeNode> nodes = new LinkedList<>();
        TreeNode current = null;

        nodes.add(null);
        nodes.offerFirst(n);

        while (!nodes.isEmpty()) {
            current = nodes.poll();

            if (current == null) {
                if (nodes.size() == 0) {
                    break;
                }
                System.out.println();
                nodes.offerLast(null);
            } else {
                if (current.getLeft() != null) {
                    nodes.offerLast(current.getLeft());
                }
                if (current.getRight() != null) {
                    nodes.offerLast(current.getRight());
                }

                System.out.print(current.getData() + " ");
            }
        }

        System.out.println();

    }

    // Lets assume its from the root for now
    public boolean doesPathExistBFS(int end) {
        Queue<TreeNode> current = new LinkedList<>();

        TreeNode n = root;
        current.offer(n);
        n.setNodeState(NodeState.VISITING);

        while (!current.isEmpty()) {
            TreeNode node = current.poll();
            if (node.getNodeState().equals(NodeState.UNVISITED) && node.getData() == end) {
                return true;
            } else {
                if (node.getLeft() != null) {
                    node.getLeft().setNodeState(NodeState.VISITING);
                    current.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    node.getRight().setNodeState(NodeState.VISITING);
                    current.offer(node.getRight());
                }
            }
            node.setNodeState(NodeState.VISITED);
        }

        return false;

    }

    public boolean doesPathExistDFS(int end) {
        TreeNode n = root;
        return doesPathExistDFSRec(n, end);
    }

    private boolean doesPathExistDFSRec(TreeNode root, int end) {
        if (null != root) {
            if (root.getData() == end) {
                return true;
            }
            return (doesPathExistDFSRec(root.getLeft(), end) || doesPathExistDFSRec(root.getRight(), end));

        }

        return false;

    }

    public TreeNode createMinimalBST(int[] input) {
        return createMinimalBSTRec(input, 0, input.length - 1);
    }

    private TreeNode createMinimalBSTRec(int[] input, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(input[mid]);
        root.setLeft(createMinimalBSTRec(input, start, mid - 1));
        root.setRight(createMinimalBSTRec(input, mid + 1, end));

        return root;
    }

    public TreeNode getRandomNode() {
        Random random = new Random();
        int index = random.nextInt(root.getSize() - 1) + 1;
        System.out.println("Random is: " + index);
        return getIthNode(index);
    }

    public TreeNode getIthNode(int index) {
        TreeNode n = root;
        return getIthNodeRec(n, index);
    }

    private TreeNode getIthNodeRec(TreeNode root, int index) {
        if (null == root) {
            return null;
        }
        int leftSize = root.getLeft() == null ? 0 : root.getLeft().getSize();
        if (index <= leftSize) {
            return getIthNodeRec(root.getLeft(), index);
        } else if (index == leftSize + 1) {
            return root;
        } else {
            return getIthNodeRec(root.getRight(), index - (leftSize + 1));
        }

    }

    public TreeNode buildFromPre(String[] chars) {
        if (index < chars.length) {
            TreeNode root1 = null;
            if (!chars[index].equals("X")) {
                int data = Integer.parseInt(chars[index]);
                root1 = new TreeNode(data);
            }
            index++;
            if (index < chars.length) {
                if (root1 != null) {
                    root1.setLeft(buildFromPre(chars));
                }
                if (root1 != null) {
                    root1.setRight(buildFromPre(chars));
                }
            }
            return root1;
        }
        return null;
    }

    public void printInorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    public void printPreorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

    }

    public void printPostorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

    private void inorder(TreeNode root) {
        if (null != root) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    private void preorder(TreeNode root) {
        if (null != root) {
            System.out.print(root.getData() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public StringBuilder preorderWithX() {
        StringBuilder builder = new StringBuilder();
        preorderWithXNull(root, builder);
        return builder;
    }

    private void preorderWithXNull(TreeNode root, StringBuilder builder) {
        if (null == root) {
            builder.append("X ");
        } else if (null != root) {
            builder.append(root.getData() + " ");
            preorderWithXNull(root.getLeft(), builder);
            preorderWithXNull(root.getRight(), builder);
        }
    }

    private void postorder(TreeNode root) {
        if (null != root) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void printInOrderIterative() {
        Deque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode n = root;
        while (true) {
            if (n != null) {
                nodes.push(n);
                n = n.getLeft();
            } else {
                if (nodes.isEmpty()) {
                    break;
                }
                TreeNode node = nodes.pop();
                System.out.print(node.getData() + ", ");
                n = node.getRight();
            }
        }
        System.out.println();
    }

    public void printPreOrderIterative() {
        Deque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode n = root;
        nodes.push(n);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (null != node.getRight()) {
                nodes.push(node.getRight());
            }
            if (null != node.getLeft()) {
                nodes.push(node.getLeft());
            }
            System.out.print(node.getData() + ", ");
        }

        System.out.println();

    }

    public void printPostOrderIterative() {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        TreeNode n = root;
        s1.push(n);

        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            if (null != node.getLeft()) {
                s1.push(node.getLeft());
            }
            if (null != node.getRight()) {
                s1.push(node.getRight());
            }
            s2.push(node);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().getData() + ", ");
        }

        System.out.println();

    }

    public TreeNode copyTree() {
        Map<TreeNode, TreeNode> treeMap = new HashMap<>();
        TreeNode result = copyTreeRec(root, treeMap);
        return result;
    }

    public TreeNode copyTreeRec(TreeNode root, Map<TreeNode, TreeNode> treeMap) {
        if (root == null) {
            return null;
        } else {
            TreeNode newRoot = new TreeNode(root.getData());
            TreeNode nodeLeft = copyTreeRec(root.getLeft(), treeMap);
            newRoot.setLeft(nodeLeft);

            TreeNode nodeRight = copyTreeRec(root.getRight(), treeMap);
            newRoot.setRight(nodeRight);
            treeMap.put(root, newRoot);
            return newRoot;

        }
    }


    private void printTree() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tree is: \n");
        List<TreeNode> current = new ArrayList<>();
        if (null != root) {
            current.add(root);
        }

        while (current.size() > 0) {
            List<TreeNode> parents = current;
            current = new ArrayList<>();
            for (TreeNode treeNode : parents) {
                if (treeNode.getLeft() != null) {
                    current.add(treeNode.getLeft());
                }
                if (treeNode.getRight() != null) {
                    current.add(treeNode.getRight());
                }
                Integer parent = null == treeNode.getParent() ? null : treeNode.getParent().getData();
                builder.append(treeNode.getData() + "(P:" + parent + ") ");
            }
            builder.append("\n");

        }

        System.out.println(builder.toString());

    }

    public TreeNode getNode(int data) {
        TreeNode n = root;
        return getNodeRec(n, data);
    }

    private TreeNode getNodeRec(TreeNode root, int data) {
        if (root == null) {
            return null;
        } else if (root.getData() == data) {
            return root;
        } else if (data < root.getData()) {
            return getNodeRec(root.getLeft(), data);
        } else
            return getNodeRec(root.getRight(), data);
    }


    public void printSize() {
        System.out.println("Size is: " + root.getSize());
    }

    public void printHeight() {
        System.out.println("Height is: " + root.getHeight());
    }


    public static void main(String[] args) {

        int[] data = {6, 10, 3, 4, 2, 7, 11, 1, 5, 8, 12};
        Tree tree = new Tree(data);
        tree.printInorder();
        tree.printPreorder();
        tree.printPostorder();
        tree.printTree();
        tree.printSize();
        tree.printHeight();

        StringBuilder builder = tree.preorderWithX();

        String chars[] = builder.toString().split("\\s");
        TreeNode res = tree.buildFromPre(chars);

        TreeNode ithNode = tree.getIthNode(11);
        System.out.println("Ith Node is: " + (ithNode == null ? null : ithNode.getData()));

        System.out.println("Random Node is: " + tree.getRandomNode().getData());

        boolean doesPathExist = tree.doesPathExistBFS(13);
        System.out.println("Does path exists BFS :" + doesPathExist);

        doesPathExist = tree.doesPathExistDFS(6);
        System.out.println("Does path exists DFS:" + doesPathExist);

        int[] inorderData = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12};

        TreeNode result = tree.createMinimalBST(inorderData);

        result.printTree();

        List<List<TreeNode>> levelNodes = tree.getLevelLists();

        tree.printLevelsSpiral();

        TreeNode node = tree.getNode(2);

        TreeNode other = tree.getNode(12);

        TreeNode succ = node.getSuccessor();
//        System.out.println("Successor of 5 is");

        System.out.println("Successor of 5 is :" + (succ == null ? null : succ.getData()));

        System.out.println("Covers is: " + node.covers(other));

        TreeNode commonAncsSibling = tree.commonAncestorSibling(node, other);
        System.out.println("Common ancestor sibling method is: " + (null != commonAncsSibling ? commonAncsSibling.getData() : null));

        int totalPaths = tree.pathsWithSum(12);

        System.out.println("Paths with sum: " + totalPaths);

        tree.printInOrderIterative();

        tree.printPreOrderIterative();

        tree.printPostOrderIterative();

        tree.printLevelsUsingQueueAndCounters();

        tree.printLevelsUsingQueueAndDelimiter();

        TreeNode newTree = tree.copyTree();
        newTree.printTree();


    }

}
