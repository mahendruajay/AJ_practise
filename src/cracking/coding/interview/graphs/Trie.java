package cracking.coding.interview.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        List<Integer> indices;

        public TrieNode() {
            this.children = new HashMap<>();
            this.indices = new ArrayList<>();
            endOfWord = false;
        }
    }

    private TrieNode root = new TrieNode();


    public void insert(String input, int location) {
        TrieNode current = root;
        for (int i = 0; i < input.length(); i++) {
            current.indices.add(location);
            char ch = input.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
            location++;
        }
        current.indices.add(location);
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }

        return current.endOfWord;

    }

    public List<Integer> searchIndexesIter(String word) {
        TrieNode current = root;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node != null) {
                current = node;
            } else {
                return result;
            }
        }
        return current.indices;
    }

    public List<Integer> searchIndexes(String word) {

        TrieNode current = root;
        List<Integer> result = searchIndexesRec(current, word);
        return result;
    }

    public List<Integer> searchIndexesRec(TrieNode root, String word) {

        if (null == word || word.length() == 0) {
            return root.indices;
        }
        char first = word.charAt(0);
        String remainder = word.substring(1);
        TrieNode node = root.children.get(first);
        if (null != node) {
            return searchIndexesRec(node, remainder);
        } else {
            return new ArrayList<>();
        }
    }

    public boolean deleteWord(String word) {
        TrieNode current = root;
        return deleteWordRec(current, word, 0);
    }

    public boolean deleteWordRec(TrieNode root, String word, int index) {

        if (index == word.length()) {
            if (!root.endOfWord) {
                return false;
            }
            root.endOfWord = false;
            return root.children.size() == 0;

        }
        char ch = word.charAt(index);
        TrieNode node = root.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean canDeleteWord = deleteWordRec(node, word, index + 1);

        if (canDeleteWord) {
            root.children.remove(ch);
            return root.children.size() == 0;
        }
        return false;

    }

    public static HashMapList<String, Integer> searchAll(String big, String... smalls) {
        Trie trie = new Trie();
        trie = createSuffixTrieFromString(trie, big);
        HashMapList<String, Integer> result = new HashMapList<>();

        for (String small : smalls) {
            List<Integer> locations = trie.searchIndexesIter(small);
            locations = subtract(locations, small.length());
            result.put(small, locations);
        }

        return result;

    }

    public static HashMapList<String, Integer> searchAllReverse(String big, String... smalls) {
        Trie trie = new Trie();
        for (String small : smalls) {
            trie.insert(small, 0);
        }

        HashMapList<String, Integer> result = new HashMapList<>();

        for (int i = 0; i < big.length(); i++) {
            List<String> strings = findStringAtLocation(trie, big, i);
            result = insertIntoMapList(result, strings, i);
        }

        return result;

    }


    public static HashMapList<String, Integer> insertIntoMapList(HashMapList mapList, List<String> strings, int index) {
        for (String string : strings) {
            mapList.put(string, index);
        }

        return mapList;
    }

    public static List<String> findStringAtLocation(Trie trie, String word, int start) {
        int index = start;
        List<String> result = new ArrayList<>();
        TrieNode root = trie.root;

        while (index < word.length()) {
            root = root.children.get(word.charAt(index));
            if (null == root) {
                break;
            }
            if (root.endOfWord) {
                result.add(word.substring(start, index + 1));
            }
            index++;
        }


        return result;

    }


    public static List<Integer> subtract(List<Integer> locations, int delta) {
        for (int i = 0; i < locations.size(); i++) {
            locations.set(i, locations.get(i) - delta);
        }

        return locations;
    }

    public static Trie createSuffixTrieFromString(Trie trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            String suffix = word.substring(i);
            trie.insert(suffix, i);
        }

        return trie;
    }


    public static void main(String[] args) {


        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        HashMapList<String, Integer> locations = searchAll(big, smalls);
        System.out.println(locations.toString());


        locations = searchAllReverse(big, smalls);
        System.out.println(locations.toString());
    }

}
