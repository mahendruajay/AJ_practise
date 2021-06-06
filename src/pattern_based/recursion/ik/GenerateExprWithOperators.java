package pattern_based.recursion.ik;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class GenerateExprWithOperators {


    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        String inp = "1001";
        StringBuilder input = new StringBuilder();

        for(char c: inp.toCharArray()){
            input.append(c);
            input.append('_');
        }
        input.deleteCharAt(input.length() -1);

        String[] op = {"j", "*", "+"};
        long target = 1001;
        genExpr(new String(input), 0, target, new StringBuilder(), op, result);
    }

    public static void genExpr(String input, int level, long target, StringBuilder builder, String[] op, List<String> result){

        if(level == input.length()){
            String expr = builder.toString();
            long res = evaluateExpr(expr);
            System.out.println("Expr: " + expr + " Res: " + res);
            if(res == target){
                result.add(sanitize(expr));
            }
            return;
        } else{
            if(Character.isDigit(input.charAt(level))){
                builder.append(input.charAt(level));
                genExpr(input, level+1, target, builder, op, result);
                builder.deleteCharAt(builder.length()-1);
            } else {
                for (int i=0; i<op.length; i++){
                    builder.append(op[i]);
                    genExpr(input, level+1, target, builder, op, result);
                    builder.deleteCharAt(builder.length()-1);
                }
            }
        }
    }

    public static String sanitize(String input){
        StringBuilder builder = new StringBuilder();
        for(char c: input.toCharArray()){
            if(c != 'j'){
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public static long evaluateExpr(String input){

        Stack<Long> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for(int i=0; i< input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
//                numStack.push(Integer.parseInt(Character.toString(input.charAt(i))));
                numStack.push(new Long(input.charAt(i) - '0'));
            } else {
                if(opStack.isEmpty()){
                    opStack.push(input.charAt(i));
                } else {
                    while(!opStack.isEmpty() && hasHigherPrecedence(opStack.peek(), input.charAt(i))){
                        char op = opStack.pop();
                        long num2 = numStack.pop();
                        long num1 = numStack.pop();
                        numStack.push(applyOp(op, num1, num2));
                    }
                    opStack.push(input.charAt(i));

                }

            }
        }

        while(!opStack.isEmpty()){
            char op = opStack.pop();
            long num2 = numStack.pop();
            long num1 = numStack.pop();
            numStack.push(applyOp(op, num1, num2));
        }

        return numStack.pop();
    }

    public static boolean hasHigherPrecedence(char op1, char op2){
        List<Character> opers = new ArrayList<>();
        opers.add('j');
        opers.add('*');
        opers.add('+');

        if (opers.indexOf(op1) < opers.indexOf(op2)){
            return true;
        } else {
            return false;
        }

    }

    public static long applyOp(char op, long operand1, long operand2){
//        System.out.println("operand1: " + operand1 + " operand2: " + operand2);
        switch (op){
            case 'j': {
                return Long.parseLong(String.valueOf(operand1) + String.valueOf(operand2));
            }
            case '*' : return operand1*operand2;
            case '+' : return  operand1 + operand2;
            default: return 0;
        }
    }



}
