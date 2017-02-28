package com.playground.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTreeNode {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree("BIBS");

        List<Integer> res = new ArrayList<Integer>();

        res = tree.search("IBS");
        res = tree.search("IBT");
        // res = tree.search("B");
        // res = tree.search("I");

        System.out.println();

    }

    Map<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
    char value;
    List<Integer> indexes = new ArrayList<Integer>();

    public SuffixTreeNode() {

    }

    public void insertString(String s, int index) {
        indexes.add(index);

        if (null != s && s.length() > 0) {
            value = s.charAt(0);

            SuffixTreeNode child = null;

            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new SuffixTreeNode();
                children.put(value, child);
            }

            String remainder = s.substring(1);
            child.insertString(remainder, index);
        }
    }

    public List<Integer> search(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        } else {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                List<Integer> subList = children.get(first).search(remainder);
                return subList;
            }
        }

        return null;
    }
}
