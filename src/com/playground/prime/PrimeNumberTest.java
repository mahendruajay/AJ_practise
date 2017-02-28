package com.playground.prime;

import java.util.Scanner;

public class PrimeNumberTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int primeNumRange = in.nextInt();

        calculatePrimeNumber(primeNumRange);

    }

    public static void calculatePrimeNumber(int primeNumberRange) {
        int num[] = new int[primeNumberRange + 1];

        for (int i = 2; i <= primeNumberRange; i++) {
            num[i] = i;
        }

        long max = (long) Math.floor(Math.sqrt(primeNumberRange));

        for (int i = 2; i <= max; i++) {
            if (num[i] != 0) {
                int square = i * i;
                while (square <= primeNumberRange) {
                    num[square] = 0;
                    square = square + i;
                }
            }
        }

        for (int i = 2; i <= primeNumberRange; i++) {
            if (num[i] != 0) {
                System.out.print(i + ", ");
            }
        }
    }

}
