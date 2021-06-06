package pattern_based.graphs.ik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {

    private String name;
    private int value;
    private int inDegree;

    private Map<String, GraphNode> neighborsMap = new HashMap<>();
    private List<GraphNode> neighbors = new ArrayList<>();


    public GraphNode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void addEdge(GraphNode other){
        if(!neighborsMap.containsKey(other.getName())){
            neighborsMap.put(other.getName(), other);
            neighbors.add(other);
            other.setInDegree(other.getInDegree()+1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public static void main(String[] args) {

    }
}
