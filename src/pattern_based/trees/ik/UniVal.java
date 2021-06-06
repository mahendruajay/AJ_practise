package pattern_based.trees.ik;

public class UniVal {

    public int findSingleValueTrees(TreeNode root){
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
//            System.out.println("Leaf node: " + root.getData()  + " num: " + res.numOfUnival);
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
        // construct a fixed style binary tree.
        Tree tree1 = new Tree();
        tree1.buildBinaryTree(new Integer[] {5,5,5,5,5,4,5, null,null,null,null,null,null,null,null,});
        tree1.bfsUsingQueue();

        UniVal uniVal = new UniVal();
        int res = uniVal.findSingleValueTrees(tree1.getRoot());
        System.out.println("Univalue Trees: " + res);

        Tree tree2 = new Tree();
        tree2.buildBinaryTree(new Integer[] {5,5,5,5,5,null,5,null, null,null,null,null,null,null,null,null,});
        tree2.bfsUsingQueue();
        int res2 = uniVal.findSingleValueTrees(tree2.getRoot());
        System.out.println("Univalue Trees: " + res2);
    }
}
