package cracking.coding.interview.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private List<GraphNode> nodes;
    private Map<String, GraphNode> nodeMap;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.nodeMap = new HashMap<>();
    }

    public GraphNode createNode(String name, int frequency) {
        if (nodeMap.containsKey(name)) {
            return nodeMap.get(name);
        } else {
            GraphNode node = new GraphNode(name, frequency);
            nodes.add(node);
            nodeMap.put(name, node);
            return node;

        }
    }


    public void addEdge(String start, String end) {
        GraphNode startNode = nodeMap.get(start);
        GraphNode endNode = nodeMap.get(end);
        if (null != startNode && null != endNode) {
            startNode.addNeighbor(endNode);
            endNode.addNeighbor(startNode);
        }
    }
}
