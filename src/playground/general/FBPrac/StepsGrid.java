package playground.general.FBPrac;

import java.util.Arrays;
import java.util.List;

public class StepsGrid {

    public int coverPoints(List<Integer> X, List<Integer> Y) {

        int steps = 0;

        int startX = X.get(0);
        int startY = Y.get(0);

        int endX = X.get(X.size() - 1);
        int endY = Y.get(Y.size() - 1);


        for (int i = 0; i < X.size() - 1; i++) {
            steps = steps + calculateStepsPointToPoint(X.get(i), Y.get(i), X.get(i + 1), Y.get(i + 1));
        }

        return steps;

    }


    private int calculateStepsPointToPoint(int startX, int startY, int endX, int endY) {
        int steps = 0;
        while (startX != endX || startY != endY) {
            if (endX > startX) {
                startX++;
            } else if (endX < startX) {
                startX--;
            }

            if (endY > startY) {
                startY++;
            } else if (endY < startY) {
                startY--;
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {

        StepsGrid stepsGrid = new StepsGrid();

        List<Integer> xList = Arrays.asList(8, 4, 8, -7, -5, -13, 9, -7, 8);
        List<Integer> yList = Arrays.asList(8, 4, -15, -10, -3, -13, 12, 8, -8);

        int result = stepsGrid.coverPoints(xList, yList);
        System.out.println("Steps are: " + result);

    }

}
