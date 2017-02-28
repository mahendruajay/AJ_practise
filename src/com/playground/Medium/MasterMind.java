package com.playground.Medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MasterMind {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MasterMind mind = new MasterMind();
        String slots = "RGBY";
        String solution = "GGRR";

        mind.printResult(slots, solution);

    }

    public void printResult(String slots, String solution) {
        int hits = 0;
        int pseudoHits = 0;
        Map<Character, List<Integer>> slot = new LinkedHashMap<Character, List<Integer>>();

        for (int i = 0; i < slots.length(); i++) {
            if (!slot.containsKey(slots.charAt(i))) {
                List<Integer> positionList = new ArrayList<Integer>();
                positionList.add(i);
                slot.put(slots.charAt(i), positionList);
            } else {
                List<Integer> positionList = slot.get(slots.charAt(i));
                positionList.add(i);
            }
        }

        for (int i = 0; i < solution.length(); i++) {
            if (slot.containsKey(solution.charAt(i))) {
                int positionHit = getPositionIndex(
                        slot.get(solution.charAt(i)), i);
                if (positionHit >= 0) {
                    hits++;
                    slot.get(solution.charAt(i)).remove(positionHit);
                    if (slot.get(solution.charAt(i)).isEmpty()) {
                        slot.remove(solution.charAt(i));
                    }
                }
            }
        }

        for (int i = 0; i < solution.length(); i++) {
            if (slot.containsKey(solution.charAt(i))) {
                pseudoHits++;

                slot.get(solution.charAt(i)).remove(0);
                if (slot.get(solution.charAt(i)).isEmpty()) {
                    slot.remove(solution.charAt(i));
                }

            }
        }

        System.out.println("Hits :" + hits);
        System.out.println("Pseudo Hits :" + pseudoHits);

    }

    private int getPositionIndex(List<Integer> positionsList, int target) {
        for (int i = 0; i < positionsList.size(); i++) {
            if (positionsList.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

}
