package playground.Miscellaneous;

public class BitVector {

    /**
     * @param args
     */
    public static void main(String[] args) {
        long numberOfInts = ((long) Integer.MAX_VALUE) + 1;

        byte[] bitField = new byte[(int) (numberOfInts / 8)];

        System.out.println(bitField.length);

        // for (int i = 0; i < 10; i++)
        // {
        // bitField[i / 8] |= 1 << (i % 8);
        // }

        // for (int item : num)
        // {
        // bitField[item / 8] |= 1 << (item % 8);
        // }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!(i == 5 || i == 101 || i == 34567 || i == 1236754)) {
                bitField[i / 8] |= 1 << (i % 8);
            }

        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int res = bitField[i / 8] & (1 << (i % 8));
            if (res == 0) {
                System.out.println("Number missing is :" + i);
                // break;
            }
        }

        System.out.println();

    }
}
