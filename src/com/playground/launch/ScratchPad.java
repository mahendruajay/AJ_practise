package com.playground.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class ScratchPad {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();

        strList.add("abcdf");
        strList.add("z");
        strList.add("abc");
        strList.add("abcde");

        for (String str : strList) {
            System.out.print(str + ", ");
        }
        System.out.println();

        Collections.sort(strList, new StringLengthComprator());

        for (String str : strList) {
            System.out.print(str + ", ");
        }
        System.out.println();

        Map<String, String> map = new LinkedHashMap<String, String>();

        for (Entry<String, String> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        int i = -10;
        int j = -6;

        System.out.println(i / j);

        Random rand = new Random();
        int random = rand.nextInt(6);

        System.out.println("Random: " + random);

        float m = 7.21f;
        float n = 7.2f;

        if ((float) m > n) {
            System.out.println("Ajay is True");
        }

    }

}
