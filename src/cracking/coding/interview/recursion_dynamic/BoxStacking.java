package cracking.coding.interview.recursion_dynamic;

import java.util.Arrays;

public class BoxStacking {

    public static void main(String[] args) {

        BoxStacking boxStacking = new BoxStacking();

        Box box1 = new Box(3, 2, 5);
        Box box2 = new Box(1, 2, 4);

        Box[] box1Combs = box1.rotate();
        Box[] box2Combs = box2.rotate();

        Box[] allBoxes = merge(box1Combs, box2Combs);

        Arrays.sort(allBoxes, new BoxBaseAreaComparator());

        int result1 = boxStacking.maxHeight(allBoxes);

        System.out.println("Result1 is: " + result1);


    }

    private static Box[] merge(Box[] boxes1, Box[] boxes2) {
        Box[] result = new Box[boxes1.length + boxes2.length];

        System.arraycopy(boxes1, 0, result, 0, boxes1.length);
        System.arraycopy(boxes2, 0, result, boxes1.length, boxes2.length);

        return result;
    }

    public int maxHeight(Box[] boxes) {

        int[] max = new int[boxes.length];
        int[] result = new int[boxes.length];

        for (int i = 0; i < boxes.length; i++) {
            max[i] = boxes[i].getHeight();
        }

        for (int i = 0; i < boxes.length; i++) {
            result[i] = i;
        }

        for (int i = 1; i < boxes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i].canFitOnTopOf(boxes[j])) {
                    int maxHeight = boxes[i].getHeight() + max[j];
                    if (maxHeight > max[i]) {
                        max[i] = maxHeight;
                        result[i] = j;
                    }

                }
            }
        }

        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIndex = -1;
        for (int i = 0; i < max.length; i++) {
            if (max[i] > maxHeight) {
                maxHeight = max[i];
                maxHeightIndex = i;
            }
        }

        int totalHeight = maxHeight;

        while (maxHeight > 0) {
            System.out.print(boxes[maxHeightIndex]);
            maxHeight = maxHeight - boxes[maxHeightIndex].getHeight();
            maxHeightIndex = result[maxHeightIndex];
        }

        return totalHeight;
    }

}
