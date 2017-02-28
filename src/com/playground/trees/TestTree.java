package com.playground.trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // Tree<Integer> myTree = new Tree<Integer>();
        // myTree.builtTree(array);

        // System.out.println(myTree.checkIfPathExists(6));
        // myTree.flattenTree();

        // myTree.flattenTree2();

        // System.out.println(myTree.determineBSTInorderStyle());

        // System.out.println(myTree.determineBSTLastPrintedStyle());

        // System.out.println(myTree.determineBSTMinMaxStyle());

        // myTree.findSum(32);

        // System.out.println("\nInorder : ");
        // myTree.printInorder();
        //
        // System.out.println("\nPreorder : ");
        // myTree.printPreorder();
        //
        // System.out.println("\nPostorder : ");
        // myTree.printPostorder();
        //
        // System.out.println("\nTree Height: " + myTree.getTreeHeight());
        //
        // myTree.breadthFirst();
        //
        // myTree.depthFirst();
        //
        // System.out.println("Is Tree Balanced version1: "
        // + myTree.isTreeBalanced());
        //
        // System.out.println("Is Tree Balanced version2: "
        // + myTree.isTreeBalancedGood());

        // int sum = myTree.sumAll();
        // System.out.println(sum);
        // myTree.count();

        String[] arr = {"6", "4", "2", "1", "$", "$", "3", "$", "$", "5", "$",
                "$", "9", "7", "$", "8", "$", "$", "10", "$", "$"};

        TestTree myTestTree = new TestTree();

        TreeNode2Result result = myTestTree.deserialize(arr, 0);

        TreeNode2 root = result.getNode();

        root.inorder(root);

        System.out.println();

        root.preorder(root);
        System.out.println();

        Scanner scanner = null;
        try {
            scanner = new Scanner(
                    new File(
                            "C://University/Project_X/inteview_practise/CircularBuffer/src/com/playground/trees/preorder_tree.txt"));

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                TreeNode2Result node = myTestTree.deserialize(
                        Integer.MAX_VALUE, Integer.MIN_VALUE, value, scanner);

                TreeNode2 node2 = node.getNode();

                node2.printInorderAndPreOrder(node2);
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e);
        } finally {
            scanner = null;
        }

    }

    public TreeNode2Result deserialize(int max, int min, int value,
                                       Scanner scanner) {

        if (value > min && value < max) {
            int nodeValue = value;
            TreeNode2 tNode = new TreeNode2(Integer.toString(nodeValue));

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
            }

            TreeNode2Result left = deserialize(nodeValue, min, value, scanner);
            if (null != left) {
                tNode.setLeft(left.getNode());
                value = left.getIndex();
            } else {
                tNode.setLeft(null);
            }

            TreeNode2Result right = deserialize(max, nodeValue, value, scanner);

            if (null != right) {
                tNode.setRight(right.getNode());
                value = right.getIndex();
            } else {
                tNode.setRight(null);
            }

            return new TreeNode2Result(tNode, value);

        }

        return null;
    }

    public TreeNode2Result deserialize(String[] data, int index) {
        if (index < data.length) {

            if (data[index] == "$") {
                return null;
            }

            TreeNode2 n = new TreeNode2(data[index]);
            TreeNode2Result left = deserialize(data, index + 1);
            if (null != left) {
                n.setLeft(left.getNode());
                index = left.getIndex();
            } else {
                n.setLeft(null);
                index = index + 2;
            }

            TreeNode2Result right = deserialize(data, index);

            if (null != right) {
                n.setRight(right.getNode());
                index = right.getIndex();
            } else {
                n.setRight(null);
                index = index + 1;
            }

            return new TreeNode2Result(n, index);
        }
        return null;

    }

}
