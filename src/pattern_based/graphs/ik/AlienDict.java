package pattern_based.graphs.ik;

import java.util.*;

public class AlienDict {


    /*
     * Complete the function below.
     */
    public String find_order(String[] words) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, List<Character>> graph = constructGraph(words);

        Set<Character> allChars = new HashSet<>();

        for(String word : words){
            for(char c: word.toCharArray()){
                if(!allChars.contains(c)){
                    allChars.add(c);
                }
            }
        }

        for(Character c: allChars){
            if(!graph.containsKey(c)){
                graph.put(c, new ArrayList<>());
            }
        }


        Map<Character, Boolean> visited = new HashMap<>();
        Map<Character, Boolean> done = new HashMap<>();

        for(Character c : graph.keySet()){
            visited.put(c, false);
        }

        for(Character c : graph.keySet()){
            done.put(c, false);
        }

        for(Character c : graph.keySet()){
            if (!visited.get(c)) {
                boolean res = dfs(graph, c, visited, done, stack);
                if(!res){
                    return "";
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for(Character c: stack){
            builder.append(c);
        }

        return builder.toString();

    }

    public boolean dfs(Map<Character, List<Character>> graph, Character node, Map<Character, Boolean> visited,
                       Map<Character, Boolean> done, Deque<Character> stack){

        visited.put(node, true);

        for(Character neighbor: graph.get(node)){
            // not visited
            if(!visited.get(neighbor)){
                boolean res = dfs(graph, neighbor, visited, done, stack);
                if(!res){
                    return false;
                }
            }
            // cycle
            if(visited.get(neighbor) && !done.get(neighbor)){
                return false;
            }
        }

        done.put(node, true);
        stack.push(node);
        return true;

    }



    public Map<Character, List<Character>> constructGraph(String[] words){

        Map<Character, List<Character>> graph = new HashMap<>();

        for(int i=0; i< words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int w1 = 0;
            int w2 = 0;
            while(w1 < word1.length() && w2 < word2.length()){
                if(word1.charAt(w1) != word2.charAt(w2)){
                    if(!graph.containsKey(word1.charAt(w1))){
                        graph.put(word1.charAt(w1), new ArrayList<>());
                    }
                    if(!graph.get(word1.charAt(w1)).contains(word2.charAt(w2))){
                        graph.get(word1.charAt(w1)).add(word2.charAt(w2));
                    }
                    break;
                }
                w1++;
                w2++;
            }

        }

        return graph;
    }

    public static void main(String[] args) {

        AlienDict alienDict = new AlienDict();

        String[] inp= {"baa", "abcd", "abca", "cab", "cad"};

        String res = alienDict.find_order(inp);

        System.out.println(res);

    }
}
