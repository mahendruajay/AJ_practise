package com.playground.Miscellaneous;

public class RemoveBandAC {

    /**
     * @param args
     */
    public static void main(String[] args) {
        RemoveBandAC remove = new RemoveBandAC();

        // char[] arr = { 'd', 'a', 'b', 'c' };
        char[] arr = {'b', 'd', 'a', 'b', 'c'};
        // char[] arr = { 'r', 'e', 'a', 'a', 'c', 't' };

        String res = remove.removeBandAC(arr);

        System.out.println(res);

        // Eliminate(arr);

    }

    public String removeBandAC(char[] input) {
        int last = -1;

        for (int i = 0; i < input.length; i++) {
            if (!(input[i] == 'b' || input[i] == 'c')) {
                last++;
                input[last] = input[i];
            }

            if (input[i] == 'b') {
                continue;
            }

            if (input[i] == 'c') {
                if (last != -1 && input[last] == 'a') {
                    last--;
                } else {
                    if (last == -1) {
                        last++;
                    }
                    input[last] = input[i];
                }
            }
        }

        if (last < 0) {
            return new String();
        }

        int offset = 0;
        int count = (last - offset) + 1;

        return new String(input, offset, count);
    }

}
