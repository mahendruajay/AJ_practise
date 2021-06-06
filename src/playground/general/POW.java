package playground.general;

import java.util.Arrays;

public class POW {

    public static double pow(double x, int n) {
        boolean isExpNeg = n < 0;
        boolean isBaseNeg = x < 0;

//        x = x * (-1);
//        n = n * (-1);

        double[] cache = new double[n + 1];
        Arrays.fill(cache, -1.0);

        double result = powRec(x, n, cache);

        if (isBaseNeg && (n % 2 == 1)) {
            result = result * (-1);
        }
        if (isExpNeg) {
            result = 1 / result;
        }

        return result;
    }

    public static double powRec(double base, int exp, double[] cache) {
        if (exp == 0) {
            return 1;
        }
        if (cache[exp] != -1.0) {
            return cache[exp];
        } else {
            if (exp % 2 == 0) {
                double oneSide = powRec(base, exp / 2, cache);
                cache[exp / 2] = oneSide;
                double result = oneSide * oneSide;
                cache[exp] = result;
                return result;
            } else {
                double oneSide = powRec(base, (exp - 1) / 2, cache);
                cache[(exp - 1) / 2] = oneSide;
                double result = oneSide * oneSide * base;
                cache[exp] = result;
                return result;
            }
        }
    }

    public static void main(String[] args) {

        double result = pow(2, 10);

        System.out.println("Result is: " + result);
    }
}
