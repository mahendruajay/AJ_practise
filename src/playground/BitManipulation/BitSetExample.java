package playground.BitManipulation;

import java.util.BitSet;

public class BitSetExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BitSet bt = new BitSet();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!(i == 5 || i == 101 || i == 5678987)) {
                bt.set(i);
            }
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!bt.get(i)) {
                System.out.println("Missing number is :" + i);
            }
        }
    }

}
