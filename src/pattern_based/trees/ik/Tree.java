package pattern_based.trees.ik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

    private TreeNode root;

    public Tree(){

    }

    public Tree(int[] input){
        for(int data: input){
            insert(data);
        }
    }

    /*
        Regular insert where node get added to the correct position in the tree.
     */
    private void insert(int data){
        TreeNode node = new TreeNode(data);
        if(root == null){
            root = node;
        } else{
            root.insert(node);
        }
    }

    public void bfsUsingQueue(){
        if(root == null){
            System.out.println("Empty Tree..");
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Using Queue Tree is: \n");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            int queueSize = queue.size();

            for(int i=0; i< queueSize; i++){
                TreeNode curr = queue.poll();
                builder.append("{");
                builder.append(curr.getData());
                builder.append(":P=");
                if(curr.getParent() == null){
                    builder.append("null");
                } else{
                    builder.append(curr.getParent().getData());
                }
                builder.append("}");
                builder.append(" ");

                if(curr.getLeft() != null){
                    queue.offer(curr.getLeft());
                }
                if(curr.getRight() != null){
                    queue.offer(curr.getRight());
                }
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

    public void bfsUsingTempList(){

        if(root == null){
            System.out.println("Empty Tree..");
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Using List Tree is: \n");

        List<TreeNode> current = new ArrayList<>();
        current.add(root);

        while(!current.isEmpty()){
            List<TreeNode> parents  = current;
            current = new ArrayList<>();
            for(TreeNode node: parents){
                if(node.getLeft() != null){
                    current.add(node.getLeft());
                }
                if(node.getRight() != null){
                    current.add(node.getRight());
                }

                builder.append("{" + node.getData() + ":P=");

                if(node.getParent() != null){
                    builder.append(node.getParent().getData() + "}");
                } else {
                    builder.append( "null}");
                }

            }
            builder.append("\n");

        }

        System.out.println(builder.toString());
    }

    public void buildBinaryTree(Integer[] input){
        TreeNode node = buildBinaryTreeHelper(input, 0);
        this.root = node;
    }

    private TreeNode buildBinaryTreeHelper(Integer[] input, int index){

        // base case
        if(input[index] == null){
            return null;
        }
        // recurse - build the tree
        TreeNode root = new TreeNode(input[index]);
        root.setLeft(buildBinaryTreeHelper(input, (2*index) +1));
        root.setRight(buildBinaryTreeHelper(input, (2*index) +2));


        return root;
    }


    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        // Build Tree using the regular approach, i.e. iterate through the array and insert each element at its correct place in the tree
        Tree tree = new Tree(new int[] {6, 10, 3, 4, 2, 7, 11, 1, 5, 8, 12});
        tree.bfsUsingQueue();
        tree.bfsUsingTempList();

    }
}
