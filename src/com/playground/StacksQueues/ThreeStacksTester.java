package com.playground.StacksQueues;

public class ThreeStacksTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ThreeStacksUsingArray threeStacks = new ThreeStacksUsingArray(3);

        try {
            threeStacks.push(0, 12);
            threeStacks.push(0, 13);
            threeStacks.push(0, 14);
            threeStacks.push(0, 15);
        } catch (StackFullException e) {
            System.out.println(e.getMessage());
        }

        try {
            threeStacks.pop(1);
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(threeStacks.pop(0));
            System.out.println(threeStacks.pop(0));
            System.out.println(threeStacks.pop(0));
            System.out.println(threeStacks.pop(0));
        } catch (StackEmptyException e) {
            System.out.println(e.getMessage());
        }

    }

}
