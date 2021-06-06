package pattern_based.dynamic_programming.ik;

public class KnightsTour {

    /*
     * Complete the numPhoneNumbers function below.
     */
    static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        /*
         * Write your code here.
         */

        int[][] moves = {{4,6}, {6,8}, {7,9}, {8,4}, {9,3,0}, {}, {7,0,1}, {2,6}, {1,3}, {4,2}};

        long[][] table = new long[phonenumberlength][10];

        for(int i=0; i< 10; i++){
            table[0][i] = 1;
        }

        for(int row=1; row< phonenumberlength; row++){
            for(int col = 0; col< 10; col++){
                long count = 0;
                for(int member :  moves[col]){
                    count = count + table[row-1][member];
                }
                table[row][col] = count;
            }
        }

        return table[phonenumberlength-1][startdigit];

    }

    public static void main(String[] args) {

        long res = numPhoneNumbers(1,30);
        System.out.println("Result: " + res);
    }

}
