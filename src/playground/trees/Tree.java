package playground.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tree<E> {
    TreeNode<E> root;

    private static Logger myLogger = Logger.getLogger(Tree.class.getName());

    public Tree() {

    }

    /**
     * Build Tree.
     *
     * @param array
     * @return
     */
    public TreeNode<E> builtTree(E[] array) {
        if (null != array && array.length > 0) {
            this.root = createBalancedTree(array, 0, array.length - 1);
        }
        return root;
    }

    /**
     * Build Tree.
     *
     * @param inputArray
     * @param start
     * @param end
     * @return
     */
    public TreeNode<E> createBalancedTree(E[] inputArray, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode<E> node = new TreeNode<E>(inputArray[mid]);
        node.setNodeState(NodeState.UNVISITED);

        node.setLeft(createBalancedTree(inputArray, start, mid - 1));
        if (null != node.getLeft()) {
            node.getLeft().setParent(node);
        }
        node.setRight(createBalancedTree(inputArray, mid + 1, end));
        if (null != node.getRight()) {
            node.getRight().setParent(node);
        }

        return node;
    }

    public void printInorder() {
        printInorder(this.root);
    }

    public void printPreorder() {
        printPreorder(this.root);
    }

    public void printPostorder() {
        printPostorder(this.root);
    }

    /**
     * Print Inorder.
     *
     * @param root
     */
    private void printInorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        printInorder(root.getLeft());
        if (myLogger.isLoggable(Level.INFO)) {
            // myLogger.log(Level.INFO, "" + root.getData());
            System.out.print("" + root.getData() + ", ");
        }
        // System.out.println("" + root.getData());
        printInorder(root.getRight());
    }

    /**
     * Print Preorder .
     *
     * @param root
     */
    private void printPreorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }

        if (myLogger.isLoggable(Level.INFO)) {
            // myLogger.log(Level.INFO, "" + root.getData());
            System.out.print("" + root.getData() + ", ");
        }
        // System.out.println("" + root.getData());
        printPreorder(root.getLeft());
        printPreorder(root.getRight());
    }

    /**
     * Print Postorder.
     *
     * @param root
     */
    private void printPostorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        printPostorder(root.getLeft());
        printPostorder(root.getRight());
        if (myLogger.isLoggable(Level.INFO)) {
            // myLogger.log(Level.INFO, "" + root.getData());
            System.out.print("" + root.getData() + ", ");
        }
        // System.out.println("" + root.getData());
    }

    public int count() {
        int count = countPostOrder(this.root);
        return count;
    }

    private int countPostOrder(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countPostOrder(root.getLeft());
        int rightCount = countPostOrder(root.getRight());

        // myLogger.log(Level.INFO, "" + root.getData());
        System.out.print("" + root.getData() + ", ");
        return leftCount + rightCount + 1;

        // System.out.println("" + root.getData());
    }

    /**
     * Tree Height.
     *
     * @return
     */
    public int getTreeHeight() {
        return getTreeHeight(this.root);
    }

    /**
     * Tree Height.
     *
     * @param root
     * @return
     */
    private int getTreeHeight(TreeNode<E> root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }

    /**
     * Check if BST.
     *
     * @return
     */
    public boolean isBinarySearchTree() {
        return false;
    }

    /**
     * BFS.
     */
    public void breadthFirst() {
        Queue<TreeNode<E>> bfsQueue = new LinkedList<TreeNode<E>>();
        this.root.setNodeState(NodeState.VISITING);
        bfsQueue.offer(this.root);

        while (!bfsQueue.isEmpty()) {
            TreeNode<E> node = bfsQueue.poll();
            visit(node);

            if (null != node.getLeft()
                    && node.getLeft().getNodeState()
                    .equals(NodeState.UNVISITED)) {
                node.getLeft().setNodeState(NodeState.VISITING);
                bfsQueue.offer(node.getLeft());
            }
            if (null != node.getRight()
                    && node.getRight().getNodeState()
                    .equals(NodeState.UNVISITED)) {
                node.getRight().setNodeState(NodeState.VISITING);
                bfsQueue.offer(node.getRight());
            }

            node.setNodeState(NodeState.VISITED);
        }

    }

    private void visit(TreeNode<E> node) {
        System.out.println("Node :" + node.getData());
    }

    /**
     * DFS
     */
    public void depthFirst() {
        dfs(this.root);
    }

    /**
     * DFS a.k.a preorder
     *
     * @param node
     */
    private void dfs(TreeNode<E> node) {
        if (null == node) {
            return;
        }
        node.setNodeState(NodeState.VISITING);
        visit(node);

        if (null != node.getLeft()
                && node.getLeft().getNodeState().equals(NodeState.UNVISITED)) {
            dfs(node.getLeft());
        }
        if (null != node.getRight()
                && node.getRight().getNodeState().equals(NodeState.UNVISITED)) {
            dfs(node.getRight());
        }
    }

    /**
     * Check if tree is balanced.
     *
     * @return
     */
    public boolean isTreeBalanced() {
        return isTreeBalanced(this.root);
    }

    /**
     * Check if tree is balanced. O(n2)
     *
     * @param root
     * @return
     */
    private boolean isTreeBalanced(TreeNode<E> root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getTreeHeight(root.left) - getTreeHeight(root.right);

        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isTreeBalanced(root.left) && isTreeBalanced(root.right);
        }
    }

    /**
     * Check if tree is balanced. O(n)
     *
     * @return
     */
    public boolean isTreeBalancedGood() {
        if (checkTreeHeight(this.root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int checkTreeHeight(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkTreeHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkTreeHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * Check if path exists.
     *
     * @param end
     * @return
     */
    public boolean checkIfPathExists(E end) {
        Queue<TreeNode<E>> treeNodes = new LinkedList<TreeNode<E>>();

        this.root.setNodeState(NodeState.VISITING);
        treeNodes.offer(this.root);

        while (!treeNodes.isEmpty()) {
            TreeNode<E> curr = treeNodes.poll();
            if (null != curr) {
                if (null != curr.getLeft()
                        && curr.getLeft().getNodeState()
                        .equals(NodeState.UNVISITED)
                        && curr.getLeft().getData() == end) {
                    return true;
                } else if (null != curr.getRight()
                        && curr.getRight().getNodeState()
                        .equals(NodeState.UNVISITED)
                        && curr.getRight().getData() == end) {
                    return true;
                } else {
                    if (null != curr.getLeft()) {
                        treeNodes.offer(curr.getLeft());
                    }
                    if (null != curr.getRight()) {
                        treeNodes.offer(curr.getRight());
                    }
                }
            }

            curr.setNodeState(NodeState.VISITED);
        }

        return false;

    }

    public void flattenTree() {
        List<List<TreeNode<E>>> treeNodes = new ArrayList<List<TreeNode<E>>>();

        flattenTree(this.root, treeNodes, 0);

        int i = 0;

        for (List<TreeNode<E>> levelList : treeNodes) {
            System.out.print("Level " + i + " : ");
            for (TreeNode<E> node : levelList) {
                System.out.print(node.getData() + ", ");
            }
            System.out.println();
            i++;
        }
    }

    private void flattenTree(TreeNode<E> root,
                             List<List<TreeNode<E>>> treeNodes, int level) {
        if (null == root) {
            return;
        }

        List<TreeNode<E>> levelList = null;

        if (treeNodes.size() == level) {
            levelList = new ArrayList<TreeNode<E>>();
            treeNodes.add(levelList);
        } else {
            levelList = treeNodes.get(level);
        }

        levelList.add(root);

        flattenTree(root.left, treeNodes, level + 1);
        flattenTree(root.right, treeNodes, level + 1);

    }

    public void flattenTree2() {
        List<List<TreeNode<E>>> treeNodes = new ArrayList<List<TreeNode<E>>>();
        List<TreeNode<E>> tempList = new ArrayList<TreeNode<E>>();

        tempList.add(this.root);

        while (tempList.size() > 0) {
            List<TreeNode<E>> levelList = new ArrayList<TreeNode<E>>(tempList);
            treeNodes.add(levelList);

            tempList.clear();

            for (TreeNode<E> node : levelList) {
                if (null != node.getLeft()) {
                    tempList.add(node.getLeft());
                }
                if (null != node.getRight()) {
                    tempList.add(node.getRight());
                }
            }

        }

        int i = 0;
        for (List<TreeNode<E>> levelList : treeNodes) {
            System.out.print("Level " + i + " : ");
            for (TreeNode<E> node : levelList) {
                System.out.print(node.getData() + ", ");
            }
            System.out.println();
            i++;
        }

    }

    public boolean determineBSTInorderStyle() {
        List<TreeNode<E>> inorderNodes = new ArrayList<TreeNode<E>>();
        setInorderNodes(this.root, inorderNodes);

        for (int i = 1; i < inorderNodes.size(); i++) {
            if (((Integer) inorderNodes.get(i).getData()) < ((Integer) inorderNodes
                    .get(i - 1).getData())) {
                return false;
            }
        }
        return true;
    }

    private void setInorderNodes(TreeNode<E> root,
                                 List<TreeNode<E>> inorderNodes) {
        if (root != null) {
            setInorderNodes(root.getLeft(), inorderNodes);

            inorderNodes.add(root);

            setInorderNodes(root.getRight(), inorderNodes);
        }
    }

    public boolean determineBSTLastPrintedStyle() {
        int lastPrinted = Integer.MIN_VALUE;

        return determineBSTLastPrintedStyle(this.root, lastPrinted);
    }

    private boolean determineBSTLastPrintedStyle(TreeNode<E> root,
                                                 int lastPrinted) {
        if (root == null) {
            return true;
        }
        if (!determineBSTLastPrintedStyle(root.getLeft(), lastPrinted)) {
            return false;
        }

        if (((Integer) root.getData()) < lastPrinted) {
            return false;
        } else {
            lastPrinted = (Integer) root.getData();
        }

        if (!determineBSTLastPrintedStyle(root.getRight(), lastPrinted)) {
            return false;
        }

        return true;

    }

    public boolean determineBSTMinMaxStyle() {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return determineBSTMinMaxStyle(this.root, min, max);
    }

    private boolean determineBSTMinMaxStyle(TreeNode<E> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if ((((Integer) root.getData()) <= min)
                || ((Integer) root.getData()) > max) {
            return false;
        }

        if (!determineBSTMinMaxStyle(root.getLeft(), min,
                ((Integer) root.getData()))
                || !determineBSTMinMaxStyle(root.getRight(),
                ((Integer) root.getData()), max)) {
            return false;
        }

        return true;

    }

    public void findSum(int sum) {
        findSum(this.root, sum);
    }

    private void findSum(TreeNode<E> root, int sum) {
        int depth = depth(root);
        int[] path = new int[depth];
        findSum(root, path, sum, 0);
    }

    private void findSum(TreeNode<E> root, int[] path, int sum, int level) {
        if (root == null) {
            return;
        }

        path[level] = (Integer) root.getData();

        int pathSum = 0;

        for (int i = level; i >= 0; i--) {
            pathSum = pathSum + path[i];

            if (pathSum == sum) {
                printPath(path, i, level);
            }
        }

        findSum(root.getLeft(), path, sum, level + 1);
        findSum(root.getRight(), path, sum, level + 1);

        path[level] = Integer.MIN_VALUE;
    }

    private void printPath(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + ", ");
        }
        System.out.println();
    }

    private int depth(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.getLeft()), depth(root.getRight()));
    }

    public Integer sumAll() {
        int sum = sumAll(this.root);

        return sum;
    }

    private Integer sumAll(TreeNode<E> root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumAll(root.left);
        int rightSum = sumAll(root.right);

        int sum = leftSum + rightSum + (Integer) root.data;

        System.out.println("Root Sum: " + sum);

        return sum;
    }

}
