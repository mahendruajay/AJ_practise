package playground.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class LongestCompositeString {

    // public String FindLongestCompositeString(java.io.File StringFile) throws
    // FileNotFoundException, IOException {
    // java.io.BufferedReader fin = new java.io.BufferedReader(new
    // java.io.FileReader(StringFile));
    // java.util.List<String> inputStrings = new java.util.ArrayList<String>();
    // while (fin.ready()) {
    // inputStrings.add(fin.readLine().trim());
    // }
    // return FindLongestCompositeString(inputStrings);
    // }

    public static void main(String[] args) {
        List<String> inputStrings = new ArrayList<String>();

        inputStrings.add("the");
        inputStrings.add("thereafter");
        inputStrings.add("there");
        inputStrings.add("reaf");
        inputStrings.add("after");
        inputStrings.add("th");
        inputStrings.add("ere");

        LongestCompositeString longest = new LongestCompositeString();

        System.out.println(longest.FindLongestCompositeString(inputStrings));

    }

    public String FindLongestCompositeString(java.util.List<String> inWords) {
        java.util.List<String> tempWords = new java.util.ArrayList<String>(
                inWords);
        java.util.Collections.sort(tempWords,
                new java.util.Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() == o2.length()) {
                            return o1.compareTo(o2);
                        } else if (o1.length() > o2.length()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                });
        while (tempWords.size() > 1) {
            String currentpossible = tempWords.get(0);
            tempWords.remove(0);
            if (findParts(currentpossible, tempWords)) {
                return currentpossible;
            }
        }
        return null;
    }

    public boolean findParts(String inPossible,
                             java.util.List<String> inputStrings) {
        if (inPossible.length() == 0) {
            return true;
        }
        for (String curPart : inputStrings) {
            if (inPossible.startsWith(curPart)) {
                if (findParts(
                        inPossible.substring(curPart.length(),
                                inPossible.length()), inputStrings)) {
                    return true;
                }
            }
        }
        return false;
    }

}
