package org.start.tress.and.graphs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private int size = 0;
    private int data;
    private NodeState nodeState;

    public TreeNode(int data) {
        size = 1;
        this.data = data;
        this.nodeState = NodeState.UNVISITED;
    }

    public boolean insert(TreeNode node)

    {
        boolean flag = false;
        if (node.getData() < this.getData()) {
            if (this.getLeft() == null) {
                this.setLeft(node);
                node.setParent(this);
                flag = true;

            } else {
                flag = this.getLeft().insert(node);

            }
        } else if (node.getData() > this.getData()) {
            if (this.getRight() == null) {
                this.setRight(node);
                node.setParent(this);
                flag = true;

            } else {
                flag = this.getRight().insert(node);
            }
        }

        if (flag) {
            this.setSize(this.getSize() + 1);
        }

        return flag;

    }

    public int getHeight() {
        if (null == this) {
            return -1;
        } else {
            int leftHeight = null == this.getLeft() ? -1 : this.getLeft().getHeight();
            int rightHeight = null == this.getRight() ? -1 : this.getRight().getHeight();
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public TreeNode getSuccessor() {
        TreeNode n = this;
        if (n.getRight() != null) {
            return n.getRight().getLeftMost();
        } else if (!isLeftChild()) {
            TreeNode parent = n.getParent();
            while (parent != null && !parent.isLeftChild()) {
                parent = parent.getParent();
            }
            if (parent == null) {
                return parent;
            }
            return parent.getParent();
        } else {
            return n.getParent();
        }
    }

    public boolean isLeftChild() {
        if (this.getParent() == null) {
            return false;
        }
        return this.getParent().getLeft() == this;
    }

    public TreeNode getLeftMost() {
        TreeNode n = this;
        while (n.getLeft() != null) {
            n = n.getLeft();
        }

        return n;
    }

    public boolean covers(TreeNode other) {
        if (other == null) {
            return false;
        }
        if (this.equals(other)) {
            return true;
        } else {

            boolean coversLeft = null != this.getLeft() ? this.getLeft().covers(other) : false;
            boolean coversRight = null != this.getRight() ? this.getRight().covers(other) : false;
            return coversLeft || coversRight;
        }
    }

    public TreeNode getSibling() {
        if (this.parent == null) {
            return null;
        }

        TreeNode parent = this.getParent();

        return this.isLeftChild() ? parent.getRight() : parent.getLeft();

    }

    public void printTree() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tree is: \n");
        List<TreeNode> current = new ArrayList<>();
        if (null != this) {
            current.add(this);
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


    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getData() {
        return data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeState getNodeState() {
        return nodeState;
    }

    public void setNodeState(NodeState nodeState) {
        this.nodeState = nodeState;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TreeNode) {
            TreeNode other = (TreeNode) obj;
            return other.getData() == this.getData();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getData();
    }
}
