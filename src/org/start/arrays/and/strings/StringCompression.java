package org.start.arrays.and.strings;

public class StringCompression {

    private String input;

    public StringCompression(String input) {
        this.input = input;
    }

    public String compress() {

        if (null == input) return "";
//        if(input.length() < 3) return input;

        if (getCompressedLength() >= input.length()) {
            return input;
        } else {
            return getCompressedString();
        }
    }

    private String getCompressedString() {
        int consecutiveCount = 0;
        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            consecutiveCount++;

            if ((i + 1) >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(consecutiveCount);
                consecutiveCount = 0;
            }
        }

        return compressed.toString();
    }

    private int getCompressedLength() {
        int compressedLength = 0;
        int consecutiveCount = 0;

        for (int i = 0; i < input.length(); i++) {
            consecutiveCount++;

            if ((i + 1) >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedLength = compressedLength + 1 + String.valueOf(consecutiveCount).length();
                consecutiveCount = 0;
            }
        }

        return compressedLength;

    }

    public static void main(String[] args) {
        String input = "aad";
        StringCompression stringCompression = new StringCompression(input);
        System.out.println(stringCompression.compress());


    }

}
