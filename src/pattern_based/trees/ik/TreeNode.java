package pattern_based.trees.ik;

import java.util.Objects;

public class TreeNode<E extends Comparable<? super E>> {

    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private int size;
    private E data;

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

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public TreeNode(E data){
        this.data = data;
    }

    public boolean insert(TreeNode node){

        boolean inserted = false;

        if(Objects.isNull(node)){
            return inserted;
        }

        if(node.getData().compareTo(this.data) == -1){
            if(this.getLeft() == null){
                this.setLeft(node);
                node.setParent(this);
                inserted = true;
            } else{
                inserted = this.getLeft().insert(node);
            }
        } else {
            if(this.getRight() == null){
                this.setRight(node);
                node.setParent(this);
                inserted = true;
            } else{
                inserted = this.getRight().insert(node);
            }
        }

        if(inserted){
            this.setSize(this.getSize() +1);
        }


        return inserted;
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}
