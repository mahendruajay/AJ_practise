package pattern_based.trees.ik;

import java.util.ArrayList;
import java.util.List;

public class DFS_Traversal {

    public void preOrder(TreeNode root, List<TreeNode> result){
        if(root != null){
            result.add(root);
            preOrder(root.getLeft(), result);
            preOrder(root.getRight(), result);
        }
    }

    public void postOrder(TreeNode root, List<TreeNode> result){
        if(root != null){
            postOrder(root.getLeft(), result);
            postOrder(root.getRight(), result);
            result.add(root);
        }

    }

    public void inOrder(TreeNode root, List<TreeNode> result){
        if(root != null){
            inOrder(root.getLeft(), result);
            result.add(root);
            inOrder(root.getRight(), result);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree(new int[] {6, 10, 3, 4, 2, 7, 11, 1, 5, 8, 12});
        tree.bfsUsingQueue();

        DFS_Traversal dfs_traversal = new DFS_Traversal();
        List<TreeNode> result = new ArrayList<>();
        dfs_traversal.preOrder(tree.getRoot(), result);
        System.out.println("PreOrder: " + result);
        result.clear();

        dfs_traversal.postOrder(tree.getRoot(), result);
        System.out.println("PostOrder: " + result);
        result.clear();

        dfs_traversal.inOrder(tree.getRoot(), result);
        System.out.println("InOrder: " + result);

        result.clear();
    }
}
