package cracking.coding.interview.graphs;

public enum NodeState {
    UNVISITED, VISITED, VISITING, UNKNOWN;

    public static NodeState getNodeStateFromString(String nodeState) {
        for (NodeState node : values()) {
            NodeState n = valueOf("UNVISITED");
            if (nodeState.equalsIgnoreCase(UNVISITED.toString())) {
                return UNVISITED;
            }
        }
        return UNKNOWN;
    }

}




