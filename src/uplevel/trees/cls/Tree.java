package uplevel.trees.cls;

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

    private void insert(int data){
        TreeNode node = new TreeNode(data);
        if(root == null){
            root = node;
        } else{
            root.insert(node);
        }
    }

    public void printTreeUsingQueue(){
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

    public void printTreeUsingTempList(){

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

    public int findSingleValueTrees(){
        if(root == null){
            return 0;
        }
        Result res = univalueTrees(root);
        return res.numOfUnival;

    }

    /*
        Given a binary tree, find the number of unival subtrees.
        An unival tree is a tree that has the same value in every node.

        For input:
               5
           5       5
        5    5       5

        Output for above tree is 6, each child node is a univalue tree, each subtree must have all nodes wiht the same value to be considered univalue.

        For input:

               5
           5       5
        5    5  4    5

        Output for above tree is 5, each child node is a univalue tree, each subtree must have all nodes wiht the same value to be considered univalue.
     */

    public Result univalueTrees(TreeNode root){
        // base case  - leaf node
        if(root.getLeft() == null && root.getRight() == null){
            Result res = new Result(true, 1);
            System.out.println("Leaf node: " + root.getData()  + " num: " + res.numOfUnival);
            return res;
        }

        Result leftRes = new Result(true, 0);
        Result rightRes = new Result(true, 0);

        Result rootRes = new Result(true, 0);
        // recursive case
        if(root.getLeft() != null){
            leftRes = univalueTrees(root.getLeft());
            rootRes.isUniVal = leftRes.isUniVal && root.getData() == root.getLeft().getData();
        }

        if(root.getRight() != null){
            rightRes = univalueTrees(root.getRight());
            rootRes.isUniVal = rootRes.isUniVal && rightRes.isUniVal && root.getData() == root.getRight().getData();
        }

        if(rootRes.isUniVal){
            rootRes.numOfUnival = 1 + leftRes.numOfUnival + rightRes.numOfUnival;
        } else {
            rootRes.numOfUnival = leftRes.numOfUnival + rightRes.numOfUnival;
        }

        return rootRes;

    }

    public static class Result{
        public boolean isUniVal;
        public Integer numOfUnival;

        public Result(boolean isUniVal, Integer numOfUnival){
            this.isUniVal = isUniVal;
            this.numOfUnival = numOfUnival;
        }
    }


    public static void main(String[] args) {
        // Build Tree using the regular approach, i.e. iterate through the array and insert each element at its correct place in the tree
        Tree tree = new Tree(new int[] {6, 10, 3, 4, 2, 7, 11, 1, 5, 8, 12});

        // construct a fixed style binary tree.
//        Tree tree1 = new Tree();
//        tree1.buildBinaryTree(new Integer[] {5,5,5,5,5,4,5, null,null,null,null,null,null,null,null,});
//        tree1.printTreeUsingQueue();
//        int res = tree1.findSingleValueTrees();
//        System.out.println("Univalue Trees: " + res);

        Tree tree2 = new Tree();
        tree2.buildBinaryTree(new Integer[] {5,5,5,5,5,null,5,null, null,null,null,null,null,null,null,null,});
        tree2.printTreeUsingQueue();
        int res2 = tree2.findSingleValueTrees();
        System.out.println("Univalue Trees: " + res2);



//        tree.printTreeUsingQueue();
//        tree.printTreeUsingTempList();

    }
}
