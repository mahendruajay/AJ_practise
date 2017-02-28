package org.start.arrays.and.strings;

public class OneEditAway {

    private String one;
    private String two;

    public OneEditAway(String one, String two) {
        this.one = one;
        this.two = two;
    }

    public boolean isOneEditAway() {
        if (Math.abs(one.length() - two.length()) > 1) return false;
        if (one.length() == two.length()) {
            return isOneReplacementAway();
        } else
            return isOneInsertDeleteAway();


    }

    private boolean isOneReplacementAway() {
        boolean found = false;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                if (found) return false;
                found = true;
            }
        }

        return true;
    }

    private boolean isOneInsertDeleteAway() {
        boolean found = false;

        String shorter = one.length() < two.length() ? one : two;
        String longer = one.length() < two.length() ? two : one;

        int index1 = 0;
        int index2 = 0;

        while (index1 < shorter.length() && index2 < longer.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                if (found) return false;
                found = true;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        String one = "ap";
        String two = "pa";

        OneEditAway oneEditAway = new OneEditAway(one, two);

        System.out.println("is one edit away: " + oneEditAway.isOneEditAway());

    }

}
