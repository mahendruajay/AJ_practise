package ByteByByte;


/*
Given two integers, write a function to determine whether or not their binary representations differ by a single bit.

eg.

gray(0, 1) = true
gray(1, 2) = false
 */

public class GrayCode {

    public static void main(String[] args) {

    }

    public static boolean gray1(int a, int b) {
        int x = a ^ b;
        while (x > 0) {
            if (x % 2 == 1 && x >> 1 > 0) return false;
            x = x >> 1;
        }
        return true;
    }

    public static boolean gray(int a, int b) {
        int x = a ^ b;
        return (x & (x - 1)) == 0;
    }

}
