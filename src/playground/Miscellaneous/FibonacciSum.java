package playground.Miscellaneous;

public class FibonacciSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(GetFibonacciSum(0, 1, 4));
    }

    private static int GetFibonacciSum(int first, int second, int count) {
        if (count < 1) {
            return -1;
        }
        if (count == 1) {
            return 0;
        }
        if (count == 2) {
            return 1;
        }

        int sum = GetFibonacciSum(second, first + second, count - 1);
        int third = first + second;

        return sum + third;

    }
}
