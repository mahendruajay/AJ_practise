package pattern_based.graphs.ik;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private List<GraphNode> nodes;
    private Map<String, GraphNode> nodesMap = new HashMap<>();


    private void addNode(String name){
        if(!nodesMap.containsKey(name)){
            GraphNode node = new GraphNode(name, 0);
            nodesMap.put(name, node);
            nodes.add(node);
        }
    }

    private void addEdge(String node1Name, String node2Name){
        GraphNode node1 = nodesMap.get(node1Name);
        GraphNode node2 = nodesMap.get(node2Name);

        node1.addEdge(node2);
    }

}
