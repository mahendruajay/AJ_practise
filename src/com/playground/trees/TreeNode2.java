package com.playground.trees;

public class TreeNode2 {
    private String data;
    private TreeNode2 left;
    private TreeNode2 right;
    private TreeNode2 parent;

    public TreeNode2(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode2 getLeft() {
        return left;
    }

    public void setLeft(TreeNode2 left) {
        this.left = left;
    }

    public TreeNode2 getRight() {
        return right;
    }

    public void setRight(TreeNode2 right) {
        this.right = right;
    }

    public TreeNode2 getParent() {
        return parent;
    }

    public void setParent(TreeNode2 parent) {
        this.parent = parent;
    }

    public void inorder(TreeNode2 root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    public void preorder(TreeNode2 root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public void printInorderAndPreOrder(TreeNode2 root) {
        inorder(root);
        System.out.println();
        preorder(root);
    }

}
