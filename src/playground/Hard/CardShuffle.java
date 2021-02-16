package playground.Hard;

import java.util.Random;

public class CardShuffle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CardShuffle card = new CardShuffle();
        int[] arr = new int[52];

        for (int i = 0; i < 52; i++) {
            arr[i] = i;
        }

        card.print(arr);
        card.shuffle(arr);
        card.print(arr);

    }

    public int[] shuffle(int[] input) {
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int temp = rand.nextInt(52 - i) + i;
            swap(input, i, temp);
        }

        return input;
    }

    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public void print(int[] input) {
        for (int item : input) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
