package pattern_based.trees.ik.live.session.prac1;

public class IsBST {

    boolean isBST = true;

    public static void main(String[] args) {
        IsBST isBST = new IsBST();
        TreeNode rootBST = TreeUtils.BST();
        TreeNode rootBinaryTree = TreeUtils.BinaryTree();
        System.out.println("rootBSTResult: " + isBST.isBST(rootBST));
//        isBST.isBST = true;
        System.out.println("rootBinaryTree: " + isBST.isBST(rootBinaryTree));
    }

    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        isBSTHelper(root, null);
        return isBST;
    }

    public TreeNode isBSTHelper(TreeNode root, TreeNode pred) {
        // base leaf
        if (root.left == null && root.right == null) {
            if (null != pred && pred.value >= root.value) {
                isBST = false;
            }
            return root;
        }
        if (root.left != null) {
            pred = isBSTHelper(root.left, pred);
            if (pred.value >= root.value) {
                isBST = false;
            }
            pred = root;

        }
        if (root.right != null) {
            pred = isBSTHelper(root.right, pred);

        }

        return pred;
    }
}
