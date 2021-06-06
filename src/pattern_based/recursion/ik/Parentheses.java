package pattern_based.recursion.ik;

/*
Find All Well Formed Brackets

Example
Input: 3
Output:
[
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
]

Given a positive integer n, return ALL strings of length 2*n with well formed round brackets.
 */

public class Parentheses {

    public static void main(String[] args) {
        int numOfPairs = 2;
        parentheses( numOfPairs, numOfPairs, new StringBuilder());
    }

    public static void parentheses(int openRemaining, int closeRemaining, StringBuilder builder){
        if(openRemaining==0 && closeRemaining==0){
            System.out.println(builder.toString());
            return;
        }
        if(closeRemaining < openRemaining){
            return;
        }
        if(openRemaining < 0 || closeRemaining <0){
            return;
        }
        builder.append('(');
        parentheses(openRemaining-1, closeRemaining, builder);
        builder.deleteCharAt(builder.length()-1);

        builder.append(')');
        parentheses(openRemaining, closeRemaining-1, builder);
        builder.deleteCharAt(builder.length()-1);
    }
}
