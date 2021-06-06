package pattern_based.searching_sorting.ik;

import java.util.Arrays;
import java.util.Random;

public class DutchNationalFlag {

    public static void main(String[] args) {
//        int[] input = {0, 2, 0, 2, 0, 0, 2, 0, 1, 0};
//        int[] input = {2, 2, 2, 0, 1 };
        int[] input = new Random().ints(10, 0, 3).toArray();

        System.out.println("Input: " + Arrays.toString(input));

        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        dutchNationalFlag.threeWayPartition(input);
        System.out.println("Partitioned: " + Arrays.toString(input));
    }

    /*
     0 = red
     1= green
     2 = blue
     */
    public void threeWayPartition(int[] input) {
        int red = 0;
        int green = 0; // current
        int blue = input.length - 1;
        while (green <= blue) {
            // current is red
            if (input[green] == 0) {
                swap(input, red, green);
                red++;
                green++;
            } else if (input[green] == 1) { // current is green
                green++;
            } else {
                // current is blue
                if (input[green] == 2)
                    swap(input, green, blue);
                blue--;
            }
        }
    }

    private void swap(int[] input, int first, int second) {
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
}
