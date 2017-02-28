package com.codeeval.developer.auction.number.palindrome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;

        try {
            File file = new File("C://University/Project_X/inteview_practise/CircularBuffer/src/com/codeeval/developer/auction/number/palindrome/playground.txt");
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String lineArray[] = line.split("\\s");
                if (lineArray.length == 1) {
                    Scanner scanner = new Scanner(lineArray[0]);
                    if (scanner.hasNextLong()) {
                        calculatePalindromeAndIterations(scanner.nextLong());
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("IOException.." + e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("IOException.. " + e.getMessage());
            }
        }

    }

    public static void calculatePalindromeAndIterations(long number) {
        long revNumber = getReverseNumber(number);
        int numberOfAdditions = 0;

        while (number - revNumber != 0) {
            number = number + revNumber;
            numberOfAdditions++;

            revNumber = getReverseNumber(number);
        }

        System.out.println(numberOfAdditions + " " + revNumber);
    }

    public static long getReverseNumber(long number) {
        long revNum = 0;
        int digit = 0;

        do {
            digit = (int) number % 10;
            number = number / 10;

            revNum = (revNum * 10) + digit;

        } while (number != 0);

        return revNum;
    }

}
