package org.start.arrays.and.strings;

public class StringRotation {

    private String s1;
    private String s2;

    public StringRotation(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    private boolean isRotation() {
        String appended = s1 + s1;
        return isSubstring(appended, s2);

    }

    public boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottla";

        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};

        for (String[] pair : pairs) {
            StringRotation stringRotation = new StringRotation(pair[0], pair[1]);
            System.out.println("Pair = {" + pair[0] + "}, {" + pair[1] + "} - " + stringRotation.isRotation());
        }


    }
}
