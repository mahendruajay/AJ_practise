package playground.Hard;

public class BitwiseMultiplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BitwiseMultiplication bitwise = new BitwiseMultiplication();
        int res = bitwise.addBitwise(12, 3);

        System.out.println(res);

        res = bitwise.multiplyBitwise(12, 2);

        System.out.println(res);
    }

    public int addBitwise(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return addBitwise(sum, carry);
    }

    public int multiplyBitwise(int a, int b) {
        int i = 0;
        int res = 0;

        for (i = 0; i < 32; i++) {
            if ((a & 1 << i) > 0) {
                res = res + (b << i);
            }
        }

        return res;

    }

}
