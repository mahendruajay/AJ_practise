package com.playground.Miscellaneous;

public class DecimalToBinary {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int num = 16;
        StringBuilder builder = new StringBuilder();

        while (num != 0) {
            int mod = num % 2;
            builder.insert(0, Integer.toString(mod));
            num = num / 2;

        }

        System.out.println(builder.toString());

    }

}
