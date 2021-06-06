package pattern_based.recursion.cc;

/*
Write a recursive function to multiply two positive integers without using the 8 or / operator. You can use addition,
subtraction and bit shifting but should minimize the number of those operations.
 */

public class RecursiveMultiply {

    public static void main(String[] args) {

        RecursiveMultiply recursiveMultiply = new RecursiveMultiply();
        System.out.println(recursiveMultiply.recursiveMultiply(6, 9));
    }

    public int recursiveMultiply(int m, int n) {
        int bigger = m > n ? m : n;
        int smaller = m < n ? m : n;
        return recursiveMultiplyHelper(bigger, smaller);
    }

    public int recursiveMultiplyHelper(int bigger, int smaller) {
        // base case
        if (smaller == 1) {
            return bigger;
        } else {
            int result = recursiveMultiply(bigger, smaller / 2);
            if (smaller % 2 == 0) {
                return result + result;
            } else {
                return bigger + result + result;
            }
        }
    }

}
