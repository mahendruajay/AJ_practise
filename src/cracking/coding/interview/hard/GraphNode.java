package cracking.coding.interview.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {

    private List<GraphNode> neighbors;
    private Map<String, GraphNode> neighborsMap;

    private String name;
    private int frequency;

    public GraphNode(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
        this.neighbors = new ArrayList<>();
        this.neighborsMap = new HashMap<>();

    }

    public boolean addNeighbor(GraphNode neighbor) {
        if (neighborsMap.containsKey(neighbor.name)) {
            return false;
        } else {
            neighbors.add(neighbor);
            neighborsMap.put(neighbor.name, neighbor);
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }
}
