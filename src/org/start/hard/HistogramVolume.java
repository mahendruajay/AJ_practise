package org.start.hard;

import java.util.LinkedList;
import java.util.Queue;

public class HistogramVolume {

    public static void main(String[] args) {

        HistogramVolume histogramVolume = new HistogramVolume();
        int[] histo = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0};

        int result = histogramVolume.calculateVolume(histo);
        System.out.println("Total volume is: " + result);

        Queue list = new LinkedList<>();

        
    }

    public int calculateVolume(int[] histo) {

        int[] leftMax = sweepLeft(histo);


        int rightMax = histo[histo.length - 1];
        int min = Math.min(leftMax[histo.length - 1], rightMax);
        int sum = min - histo[histo.length - 1];

        for (int i = histo.length - 2; i >= 0; i--) {
            if (histo[i] > rightMax) {
                rightMax = histo[i];
            }

            min = Math.min(leftMax[i], rightMax);
            sum += min - histo[i];

        }

        return sum;
    }

    public int[] sweepLeft(int[] histo) {
        int[] leftMax = new int[histo.length];
        int max = histo[0];
        leftMax[0] = max;

        for (int i = 1; i < histo.length; i++) {
            if (histo[i] > max) {
                max = histo[i];
            }
            leftMax[i] = max;
        }

        return leftMax;
    }

}
