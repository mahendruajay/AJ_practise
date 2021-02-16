package playground.Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneInputCharPermutations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Character[] one = {'a', 'b', 'c'};
        Character[] two = {'d', 'e', 'f'};
        Character[] three = {'g', 'h', 'i'};

        Map<Integer, Character[]> map = new HashMap<Integer, Character[]>();

        map.put(1, one);
        map.put(2, two);
        map.put(3, three);

        int[] input = {1, 2, 3};

        List<Character> list = new ArrayList<Character>();

        print(input, 0, map, list);

    }

    public static void print(int[] input, int inputStartPos,
                             Map<Integer, Character[]> ncMap, List<Character> accumulator) {
        if (input == null || inputStartPos < 0
                || inputStartPos > input.length - 1) {
            return;
        }
        Character[] chars = ncMap.get(input[inputStartPos]);
        if (inputStartPos == input.length - 1) {
            for (int i = 0; i < chars.length; i++) {
                printAccumulator(accumulator); // print all chars we have so
                // far.
                System.out.print(chars[i]);
                System.out.print(" ");
            }

            return; // success
        } else {
            for (int i = 0; i < chars.length; i++) {
                accumulator.add(chars[i]);
                print(input, inputStartPos + 1, ncMap, accumulator);
                accumulator.remove(accumulator.size() - 1);
            }
        }
    }

    public static void printAccumulator(List<Character> accumulator) {
        for (Character c : accumulator) {
            System.out.print(c);
        }

    }

}
