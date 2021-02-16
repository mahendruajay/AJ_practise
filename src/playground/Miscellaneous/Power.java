package playground.Miscellaneous;

public class Power {
    private static int COUNT;

    /**
     * @param args
     */
    public static void main(String[] args) {
        int result = power(2, 0);
        System.out.println(result);
        System.out.println(COUNT);

    }

    public static int power(int n, int x) {
        COUNT++;
        if (x == 0) {
            return 1;
        }
        if (x == 1) {
            return n;
        }
        if (x % 2 == 0) {
            return power(n * n, x / 2);
        } else {
            return (power(n * n, x / 2) * n);
        }

    }

}
