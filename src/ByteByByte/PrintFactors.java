package ByteByByte;

public class PrintFactors {

    public static void main(String[] args) {

//        findFactor(12, 12, "");
        printFactor(12);
    }

    private static void printFactor(int n) {
        if (n <= 0) {
            System.out.print("Wrong input!");
            return;
        }
        if (n == 1) {
            System.out.print("1");
            return;
        }
        long[] a = new long[n / 2];
        findFactor(n / 2, n, a, 0);

    }

    private static void findFactor(long half, long n, long[] arr, int index) {
        if (half == 1) {
            if (n == 1) {
                for (int k = 0; k < index - 1; k++) {
                    System.out.print(arr[k]);
                    if (k < index - 2) {
                        System.out.print("*");
                    }
                }
                System.out.println();

            }
            return;
        }
        for (long k = half; k >= 1; k--) {
            if (n % k == 0) {
                arr[index] = k;
                findFactor(k, n / k, arr, index + 1);
            }
        }
    }

    public static void findFactor(int x, int prev, String outStr) {

        if (x == 1) {
            if (outStr.indexOf("*") == -1) {
                outStr += " * 1";
            }
            System.out.println(outStr);

        }

        for (int i = x; i > 0; i--) {
            if ((x % i == 0) && prev >= i) {

                if (!outStr.isEmpty()) {
                    outStr += " * ";
                } else {
                    outStr += "";
                }

                String num = String.valueOf(i);

                findFactor(x / i, i, outStr + num);
            }
        }


    }


}
