package com.amazon.test;

public class InputStreamTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Given playground case
        InputStream testInputStream = new InputStream("aAbBABac");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - Empty String.
        testInputStream = new InputStream("");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - null String.
        testInputStream = new InputStream(null);
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - Staring has one character.
        testInputStream = new InputStream("a");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - String has no non repeating character.
        testInputStream = new InputStream("aa");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - Normal String.
        testInputStream = new InputStream("aBcdefgrthyaBcdefgrt");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - String has no non repeating character.
        testInputStream = new InputStream("aabbccddd");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());

        // Test case - Normal String.
        testInputStream = new InputStream("abcd");
        System.out.println("First non repeating character is: " + testInputStream.getFirstNonRepeatingCharacter());


    }

}
