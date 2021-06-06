package pattern_based.graphs.ik;

import java.util.*;

public class CriticalConnections {


    /*
     * Complete the function below.
     */

    // Solved using Trajan's algo, if this algo was not known it would have been difficult to solve in V+E time.

    // Brute force is iterate through all given edges and then do dfs for each edge be removing that edge from the graph,
    // but this will take E*(V+E) time as we will run dfs for each edge removal. In this case if the dfs returns more
    // than one component then that edge is critical.

    static int time = 0;

    public static List<List<Integer>> find_critical_connections(
            int number_of_servers, List<List<Integer>> connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i< number_of_servers; i++){
            graph.put(i, new ArrayList<>());
        }

        graph = constructGraph(connections, graph);

        // An id given to each node as it is discovered.
        int[] discovered = new int[number_of_servers];

        // low represents the lowest id reachable from a current node.
        int[] low = new int[number_of_servers];

        boolean[] visited = new boolean[number_of_servers];

        Integer[] parent = new Integer[number_of_servers];

        List<List<Integer>> result = new ArrayList<>();

        for(Integer node: graph.keySet()){
            if(!visited[node]){
                dfs(graph, node, visited, discovered, low, result, parent);
            }
        }

        if(!result.isEmpty()){
            return result;
        } else {
            result.add(Arrays.asList(new Integer[]{-1,-1}));
            return result;
        }

    }

    static void dfs(Map<Integer, List<Integer>> graph, Integer node, boolean[] visited, int[] discovered,
                    int[] low, List<List<Integer>> result, Integer[] parent){

        visited[node] = true;
        discovered[node] = time;
        low[node] = time;
        time++;

        for(Integer neighbor: graph.get(node)){
            if(!visited[neighbor]){
                parent[neighbor] = node;
                dfs(graph, neighbor, visited, discovered, low, result, parent);

                low[node]  = Math.min(low[node], low[neighbor]);

                if (discovered[node] < low[neighbor]){
                    result.add(Arrays.asList(new Integer[]{node, neighbor}));

                }
            }

            else if(visited[neighbor] && neighbor != parent[node]){
                low[node]  = Math.min(low[node], low[neighbor]);
            }


        }

    }



    static Map<Integer, List<Integer>> constructGraph(List<List<Integer>> connections,
                                                      Map<Integer, List<Integer>> graph){


        for(List<Integer> pair : connections){
            int node1 = pair.get(0);
            int node2 = pair.get(1);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

        }

        return graph;
    }

    public static void main(String[] args) {

        int numOfServers = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(new Integer[]{0,1}));
        connections.add(Arrays.asList(new Integer[]{0,2}));
        connections.add(Arrays.asList(new Integer[]{0,3}));
        connections.add(Arrays.asList(new Integer[]{1,2}));
        connections.add(Arrays.asList(new Integer[]{2,3}));

        List<List<Integer>> res = find_critical_connections(numOfServers, connections);
        System.out.println(res);

    }


}
