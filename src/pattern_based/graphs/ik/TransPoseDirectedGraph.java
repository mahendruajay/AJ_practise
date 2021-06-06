package pattern_based.graphs.ik;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class TransPoseDirectedGraph {

    /*
     * Complete the function below.
     */

    public static class Node
    {
        Integer val;
        Vector<Node> neighbours = new Vector<Node>(0);
        Node(Integer _val)
        {
            val = _val;
            neighbours.clear();
        }
    };


    static Node build_other_graph(Node node)
    {

        Map<Integer, Node> transpose = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        dfs(node, transpose, visited);
        Node[] res = transpose.values().toArray(new Node[0]);
        return res[0];
    }

    static void dfs(Node node, Map<Integer, Node> transpose, Map<Integer, Boolean> visited){

        visited.put(node.val, true);
        Node trans = new Node(node.val);
        transpose.put(node.val, trans);

        for(Node neighbor: node.neighbours){
            if(visited.get(neighbor.val) == null || !visited.get(neighbor.val)){
                dfs(neighbor, transpose, visited);
            }

            transpose.get(neighbor.val).neighbours.add(transpose.get(trans.val));
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbours.add(node2);
        node2.neighbours.add(node3);
        node3.neighbours.add(node1);

        Node res = build_other_graph(node1);
        System.out.println(res.val);
    }
}
