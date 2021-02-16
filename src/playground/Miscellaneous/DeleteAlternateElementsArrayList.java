package playground.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class DeleteAlternateElementsArrayList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(8);
        // list.add(1);
        // list.add(5);
        // list.add(9);
        // list.add(12);
        // list.add(15);

        DeleteAlternateElementsArrayList del = new DeleteAlternateElementsArrayList();

        del.deleteAlternate(list);

        for (Integer item : list) {
            System.out.print(item + " ");
        }

    }

    public void deleteAlternate(List<Integer> list) {
        int iterations = 0;
        // Even
        if (list.size() % 2 == 0) {
            iterations = list.size() / 2;
        } else {
            // Odd
            iterations = (list.size() / 2) + 1;
        }

        for (int i = 0; i < iterations; i++) {
            list.remove(i);
        }
    }

}
