package pattern_based.graphs.ik;

import java.util.*;

public class WordTransform {

    /*
     * Complete the function below.
     */
    public String[] string_transformation(String[] words, String start, String stop) {

        Map<String, List<String>> allWords = new HashMap<>();

        allWords.put(start, new ArrayList<>());
        for(String word : words){
            allWords.put(word, new ArrayList<>());
        }
        allWords.put(stop, new ArrayList<>());
        constructGraph(allWords);


        Deque<String> output = bfs(allWords, start, stop);

        if(output.isEmpty()){
            output.offerFirst("-1");
        }

        return output.toArray(new String[0]);

    }

    public Deque<String> bfs(Map<String, List<String>> allWords, String start, String stop){
        Map<String, String> parentMap = new HashMap<>();
        for(String word: allWords.keySet()){
            parentMap.put(word, null);
        }

        Map<String, Boolean> visitedMap = new HashMap<>();
        for(String word: allWords.keySet()){
            visitedMap.put(word, false);
        }


        Deque<String> queue = new ArrayDeque<>();
        Deque<String> output = new ArrayDeque<>();

        queue.offer(start);
        visitedMap.put(start, true);

        while(!queue.isEmpty()){

            int qSize = queue.size();
            for(int i=0;i < qSize; i++){
                String curr = queue.poll();
                for(String neighbor: allWords.get(curr)){
                    if(neighbor.equals(stop)){
                        String parent = curr;
                        while(!parent.equals(start)){
                            output.offerFirst(parent);
                            parent = parentMap.get(parent);
                        }
                        output.offerFirst(start);
                        output.offerLast(neighbor);
                        return output;
                    } else{
                        if(!visitedMap.get(neighbor)) {
                            parentMap.put(neighbor, curr);
                            queue.offer(neighbor);
                            visitedMap.put(neighbor, true);
                        }
                    }

                }
            }
        }

        return output;
    }

    public void constructGraph(Map<String, List<String>> allWords){

        for(String word1: allWords.keySet()){
            for(String word2: allWords.keySet()){
                if(isOneWordAway(word1, word2)){
                    allWords.get(word1).add(word2);
                }
            }
        }
    }

    public boolean isOneWordAway(String one, String two){

        if(one.length() != two.length() || one.equals(two)){
            return false;
        }
        boolean found = false;

        for(int i=0; i< one.length(); i++){
            if(one.charAt(i) != two.charAt(i)){
                if(found){
                    return false;
                }
                found = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        WordTransform wordTransform = new WordTransform();

//        String[] words = {"cat", "hat", "bad", "had"};
//        String start = "bat";
//        String stop = "had";

//        String[] words = {"ggggnn", "gggnnn", "gggggn", "ggnnnn", "gnnnnn"};
//        String start = "gggggg";
//        String stop = "nnnnnn";

        String[] words = {};
        String start = "zzzzzz";
        String stop = "zzzzzz";

//        String[] words = {};
//        String start = "bbb";
//        String stop = "bbc";

        String[] op = wordTransform.string_transformation(words, start, stop);

        for(String word: op){
            System.out.println(word);
        }


    }


}
