package pattern_based.searching_sorting;

import java.util.Random;

public class RandomArray {

    private int numberOfElements;

    public RandomArray(int numberOfElements) {
        this.numberOfElements = numberOfElements;

    }

    public int[] generateArrayBound() {
        int[] randomArray = new int[numberOfElements];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            int num = random.nextInt(numberOfElements);
            randomArray[i] = num;
        }

        return randomArray;
    }

    public int[] generateAnyInt() {
        int[] randomArray = new int[numberOfElements];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            int num = random.nextInt();
            randomArray[i] = num;
        }

        return randomArray;
    }

    public int[] generateGivenBound(int low, int high) {
        int[] randomArray = new int[numberOfElements];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            int num = random.nextInt(high - low) + low;
            randomArray[i] = num;
        }

        return randomArray;
    }
}
