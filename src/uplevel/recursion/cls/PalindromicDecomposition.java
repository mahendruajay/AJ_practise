package uplevel.recursion.cls;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecomposition {

    public static void main(String[] args) {
        String input = "abracadabra";
//        String input = "abcd";
//        palinDecomp(input, 0, new StringBuilder());

        List<String> results = new ArrayList<>();
        generate(input.toCharArray(), 0, new char[2 * input.length()], 0, results);

        String[] res = results.toArray(new String[results.size()]);
        for(String s : res){
            System.out.println(s);
        }

    }

    public static void palinDecomp(String input, int level, StringBuilder sb){
        if(level == input.length()){
//            System.out.println(sb.toString());
            if(sb.toString().equals(sb.reverse().toString())) {
                System.out.println(sb.toString());
            }
        } else{

            palinDecomp(input, level+1, sb);
            sb.append(input.charAt(level));
            palinDecomp(input, level+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void generate(char[] s, int pos, char[] out, int j, List<String> results) {
        if (pos == s.length) {
            results.add(new String(out, 0, j - 1));
            return;
        }

        for (int i = pos; i < s.length; i++) {
            int lengthOfCharAdded = i - pos;
            out[j + lengthOfCharAdded] = s[i];
            if (isPalindrome(s, pos, i)) {
                out[j + (i - pos) + 1] = '|';
                generate(s, pos + lengthOfCharAdded + 1, out, j + lengthOfCharAdded + 2 /* 1 for | and 1 for next char*/, results);
            }
        }
    }

    public static boolean isPalindrome(char[] arr, int lo, int hi) {
        while (lo < hi) {
            if (arr[lo] != arr[hi]) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

}
