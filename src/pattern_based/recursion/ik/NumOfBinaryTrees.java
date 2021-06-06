package pattern_based.recursion.ik;

public class NumOfBinaryTrees {

    public static void main(String[] args) {
        long numWays = 0;
        int n = 3;
        System.out.println(numBST(n));

    }

    public static long numBST(int numNodes){
        if(numNodes <= 1){
            return 1;
        }

        /*
        Consider all possible binary search pattern_based.trees with each element at the root.
        If there are n nodes, then for each choice of root node, there are n – 1 non-root nodes and
        these non-root nodes must be partitioned into those that are less than a chosen root and those that are greater
        than the chosen root.

        Let’s say node i is chosen to be the root.
        Then there are i – 1 nodes smaller than i and n – i nodes bigger than i.
        For each of these two sets of nodes, there is a certain number of possible subtrees.
         */

        long sum = 0;
        for(int root = 1; root <= numNodes ; root++){
            long left = numBST(root-1);
            long right = numBST(numNodes - root);

            sum+=left*right;
        }

        return sum;
    }


}
