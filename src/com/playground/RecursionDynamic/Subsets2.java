package com.playground.RecursionDynamic;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<List<Integer>> list1 = new ArrayList<List<Integer>>();

        List<Integer> emptySet = new ArrayList<Integer>();
        list1.add(emptySet);

        Subsets2 subset = new Subsets2();

        subset.getSubsets(list, list1, 0);
        System.out.println(list1);
    }

    public void getSubsets(List<Integer> set, List<List<Integer>> result,
                           int index) {
        for (int i = 0; i < set.size(); i++) {
            int item = set.get(i);
            List<List<Integer>> moreSubsets = new ArrayList<List<Integer>>();
            for (List<Integer> subset : result) {
                List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            result.addAll(moreSubsets);

            // for (List<Integer> ns : moreSubsets)
            // {
            // result.add(ns);
            // }
        }
    }

}
