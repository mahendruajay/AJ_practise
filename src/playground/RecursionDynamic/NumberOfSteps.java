package playground.RecursionDynamic;

public class NumberOfSteps {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] map = new int[15];
        System.out.println(countWays(4, map));

    }

    public static int countWays(int n, int[] map) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWays(n - 1, map) + countWays(n - 2, map)
                    + countWays(n - 3, map);

            return map[n];
        }
    }

}
