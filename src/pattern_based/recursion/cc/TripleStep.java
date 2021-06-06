package pattern_based.recursion.cc;
/*
A child is running up a staircase with n steps and can hop either 1 step or 2 steps or 3 steps at a time. Implement a method
to count how manny possible ways the child can run up to the stairs.
 */


import cracking.coding.interview.graphs.HashMapList;

import java.util.HashMap;
import java.util.Map;

public class TripleStep {

    public static void main(String[] args) {
        TripleStep tripleStep = new TripleStep();

        int numSteps = 4;
        System.out.println("Result: " + tripleStep.tripleStep(numSteps));

        System.out.println("Result Memo: " + tripleStep.tripleStepMemo(numSteps));
    }

    public int tripleStep(int numSteps) {
        return tripleStepHelper(numSteps, 0);
    }

    public int tripleStepHelper(int numSteps, int idx) {
        if (idx > numSteps) {
            return 0;
        } else if (idx == numSteps) {
            return 1;
        } else {
            int one = tripleStepHelper(numSteps, idx + 1);
            int two = tripleStepHelper(numSteps, idx + 2);
            int three = tripleStepHelper(numSteps, idx + 3);
            return one + two + three;
        }
    }

    public int tripleStepMemo(int numSteps) {
        Map<Integer, Integer> cache = new HashMap<>();

        return tripleStepHelperMemo(numSteps, 0, cache);
    }

    public int tripleStepHelperMemo(int numSteps, int idx, Map<Integer, Integer> cache) {
        if (idx > numSteps) {
            return 0;
        } else if (idx == numSteps) {
            return 1;
        } else if (cache.containsKey(idx)) {
            return cache.get(idx);
        } else {
            int one = tripleStepHelperMemo(numSteps, idx + 1, cache);
            int two = tripleStepHelperMemo(numSteps, idx + 2, cache);
            int three = tripleStepHelperMemo(numSteps, idx + 3, cache);
            cache.put(idx, one + two + three);
            return cache.get(idx);
        }
    }
}
