package cracking.coding.interview.recursion_dynamic;

public class RecursiveMultiplication {

    public static int recMult(int first, int second) {
        int smaller = first > second ? second : first;
        int bigger = first > second ? first : second;

        return recMultHelper(smaller, bigger);
    }

    private static int recMultHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        }
        if (smaller == 1) {
            return bigger;
        }

        int half = smaller >> 1;
        int halfProd = recMultHelper(half, bigger);

        if (smaller % 2 == 1) {
            return halfProd + halfProd + bigger;
        } else {
            return halfProd + halfProd;
        }
    }


    public static void main(String[] args) {
        int first = 7;
        int second = 123;

        int result = recMult(first, second);

        System.out.println("Mult is: " + result);
    }
}
