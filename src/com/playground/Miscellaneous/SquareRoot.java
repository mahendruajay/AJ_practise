package com.playground.Miscellaneous;

public class SquareRoot {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final double ERROR = 0.000000001;

        SquareRoot sqrt = new SquareRoot();

        System.out.println(sqrt.findsqrt(30.0, ERROR));

        double payment = 0.1;
        double sum = 0.0;

        for (int i = 0; i < 10; i++) {
            sum += payment;
        }

        System.out.println(sum);

        payment = 0.125;
        sum = 0.0;

        for (int i = 0; i < 8; i++) {
            sum += payment;
        }
        System.out.println(sum);

    }

    public double findsqrt(double number, double ERROR) {
        double low = 0;
        double high = number;

        while ((high - low) > ERROR) {
            double mid = (low + high) / 2.0;
            if ((mid * mid) > number) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

}
