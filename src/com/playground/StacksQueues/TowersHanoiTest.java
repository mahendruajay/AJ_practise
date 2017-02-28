package com.playground.StacksQueues;

public class TowersHanoiTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int numberOfDiscs = 3;
        int numberOfTowers = 3;
        HanoiTower[] hanoiTowers = new HanoiTower[numberOfTowers];

        for (int i = 0; i < numberOfTowers; i++) {
            hanoiTowers[i] = new HanoiTower(i);
        }

        for (int i = numberOfDiscs - 1; i >= 0; i--) {
            hanoiTowers[0].addDisk(i);
        }

        hanoiTowers[0].moveDisks(numberOfDiscs, hanoiTowers[2], hanoiTowers[1]);

    }

}
