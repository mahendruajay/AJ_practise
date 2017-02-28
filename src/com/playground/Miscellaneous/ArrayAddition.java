package com.playground.Miscellaneous;

public class ArrayAddition {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayAddition obj = new ArrayAddition();

        int[] arr = {5, 9, 9};

        int[] res = obj.addArray(arr, 600);

        for (int item : res) {
            System.out.print(item + " ");
        }

    }

    public int[] addArray(int[] input, int number) {
        int carry = 0;
        int result = 0;
        int resDigit = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            if (number != 0) {
                int numDigit = number % 10;

                result = input[i] + numDigit;
                carry = result / 10;
                resDigit = result % 10;

                input[i] = resDigit;

                number = number / 10;
            } else {
                result = input[i] + carry;

                carry = result / 10;
                resDigit = result % 10;

                input[i] = resDigit;

            }

        }

        if (carry > 0) {
            int[] newResult = new int[input.length + 1];
            newResult[0] = carry;
            int i = 1;
            for (int j = 0; j < input.length; j++) {
                newResult[i] = input[j];
                i++;
            }

            return newResult;
        }

        return input;
    }

}
