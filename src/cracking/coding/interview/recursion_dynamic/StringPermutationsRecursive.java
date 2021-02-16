package cracking.coding.interview.recursion_dynamic;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsRecursive {

    public static void main(String[] args) {

        StringPermutationsRecursive strRec = new StringPermutationsRecursive();
        String input = "abc";
        List<String> result = new ArrayList<>();
        strRec.permute("", input, result);

        System.out.println(result);
    }

    public void permute(String prefix, String remaining, List<String> result) {

        if (remaining.equals("")) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String before = remaining.substring(0, i);
            String after = remaining.substring(i + 1);
            char c = remaining.charAt(i);
            permute(prefix + c, before + after, result);
        }

    }

}
