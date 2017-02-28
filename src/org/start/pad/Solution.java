package org.start.pad;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note) {
        this.magazineMap = new HashMap();
        this.noteMap = new HashMap();

        constructMagMap(magazine);
        constructNoteMap(note);

    }

    private void constructMagMap(String magazine) {
        Scanner scanner = new Scanner(magazine);
        while (scanner.hasNext()) {
            String token = scanner.next();
            populateMap(magazineMap, token);
        }

    }

    private void constructNoteMap(String note) {
        Scanner scanner = new Scanner(note);
        while (scanner.hasNext()) {
            String token = scanner.next();
            populateMap(noteMap, token);
        }

    }

    private void populateMap(Map<String, Integer> map, String token) {
        Integer value = map.get(token);
        if (null != value) {
            value = value + 1;
        } else {
            value = 1;
        }
        map.put(token, value);
    }

    public boolean solve() {
        for (String token : noteMap.keySet()) {
            Integer tokenValue = noteMap.get(token);
            for (int i = 0; i < tokenValue; i++) {
                if (!magazineMap.containsKey(token)) {
                    return false;
                } else {
                    Integer value = magazineMap.get(token);
                    value--;
                    if (value == 0) {
                        magazineMap.remove(token);
                    } else {
                        magazineMap.put(token, value);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
//        scanner.nextLine();

        Solution s = new Solution("zahk dp apdz clo e dk awfvf osb qr sa cqjq zgr nvxtb abjy axa ili wdyw soqku buwcl qcub sautu ii vkrzl bdob nona al zg ombzc c dbun f xkuo lsax hfki j dfft uce ugj ywz vucgg xq udrkt ypy tmxgc ty gar kty dc bznj pzzx clo apdz nvxtb clo sa clo zahk awfvf soqku udrkt udrkt e ypy xkuo tmxgc ombzc wdyw al axa lsax clo abjy osb apdz bdob pzzx zahk c bznj gar osb xkuo zahk zg uce zg clo e apdz gar xq dbun buwcl ili bznj clo osb dc dbun ywz",
                "buwcl qr axa ypy zahk nvxtb dp hfki ii uce dc zg dbun ypy ty cqjq zg kty bznj zg zahk dp c al ugj ywz qcub ywz wdyw hfki gar e axa dp qr kty bznj clo ty vucgg qcub al vkrzl qcub j awfvf soqku lsax bdob nvxtb");
//        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
