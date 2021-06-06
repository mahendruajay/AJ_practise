package pattern_based.trees.ik;

import java.util.*;

public class BFS_LevelOrder {

    public List<List<TreeNode>> bfsUsingQueue(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            int queueSize = queue.size();
            List<TreeNode> levelList = new ArrayList<>();

            for(int i=0; i< queueSize; i++){
                TreeNode curr = queue.poll();
                levelList.add(curr);

                if(curr.getLeft() != null){
                    queue.offer(curr.getLeft());
                }
                if(curr.getRight() != null){
                    queue.offer(curr.getRight());
                }
            }
            result.add(levelList);

        }

        return result;

    }

    public List<List<TreeNode>> bfsUsingTempList(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);

        while(!curr.isEmpty()){
            List<TreeNode> parents = curr;
            result.add(new ArrayList<>(parents));
            curr = new ArrayList<>();

            for(TreeNode node : parents){
                if(node.getLeft() != null){
                    curr.add(node.getLeft());
                }
                if(node.getRight() != null){
                    curr.add(node.getRight());
                }
            }
        }

        return result;
    }

    public List<List<TreeNode>> zigZagTraversal(TreeNode root){
        List<List<TreeNode>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean flip = false;

        queue.offer(root);

        while(!queue.isEmpty()){

            int qSize = queue.size();
            List<TreeNode> temp = new ArrayList<>();
            for(int i=0; i< qSize; i++){
                TreeNode node = queue.poll();
                temp.add(node);
                if(node.getLeft() != null){
                    queue.offer(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.offer(node.getRight());
                }
            }
            if(flip){
                Collections.reverse(temp);
            }
            flip = !flip;
            result.add(temp);

        }

        return result;
    }

    public List<TreeNode> rightSideView(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);


        while(!queue.isEmpty()) {
            int qSize = queue.size();
            List<TreeNode> temp = new ArrayList<>();

            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                temp.add(node);
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            result.add(temp.get(temp.size()-1));

        }

        return result;
    }


    public static void main(String[] args) {
        Tree tree = new Tree(new int[] {6, 10, 3, 4, 2, 7, 11, 1, 5, 8, 12});
        BFS_LevelOrder bfs_levelOrder = new BFS_LevelOrder();
        List<List<TreeNode>> result = bfs_levelOrder.bfsUsingQueue(tree.getRoot());
        System.out.println("BFS using Queue: ");
        for(List<TreeNode> nodes : result){
            System.out.println(nodes);
        }

        System.out.println("BFS using TempList: ");
        result = bfs_levelOrder.bfsUsingTempList(tree.getRoot());
        for(List<TreeNode> nodes : result){
            System.out.println(nodes);
        }

        System.out.println("ZigZag level order traversal using Queue: ");
        result = bfs_levelOrder.zigZagTraversal(tree.getRoot());
        for(List<TreeNode> nodes : result){
            System.out.println(nodes);
        }

        System.out.println("RightSideView: ");
        List<TreeNode> rightSideViewResult = bfs_levelOrder.rightSideView(tree.getRoot());
        System.out.println(rightSideViewResult);
    }

}
