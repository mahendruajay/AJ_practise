package pattern_based.recursion.ik;

import java.util.HashMap;
import java.util.Map;

public class DialPad {

    public static void main(String[] args) {
        Map<Character, char[]> tab = new HashMap<>();
        tab.put('2', new char[]{'A','B', 'C'});
        tab.put('3', new char[]{'D','E', 'F'});
        tab.put('4', new char[]{'G','H', 'I'});
        tab.put('5', new char[]{'J','K', 'L'});
        tab.put('6', new char[]{'M','N', 'O'});
        tab.put('7', new char[]{'P','Q', 'R', 'S'});
        tab.put('8', new char[]{'V','U', 'V'});
        tab.put('9', new char[]{'W','X', 'Y', 'Z'});
        tab.put('0', new char[]{'0'});
        tab.put('1', new char[]{'1'});

        String input = "1234567890";

        dialPad(input, 0, tab, new StringBuilder());
    }

    public static void dialPad(String input, int level, Map<Character, char[]> tab, StringBuilder builder){
        if(level == input.length()){
            System.out.println(builder.toString());
        } else{
            char curr = input.charAt(level);
            char[] currArr = tab.get(curr);
            for(int i=0; i< currArr.length; i++){
                builder.append(currArr[i]);
                dialPad(input, level+1, tab, builder);
                builder.deleteCharAt(level);
            }
        }

    }
}
