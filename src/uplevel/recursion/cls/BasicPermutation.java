package uplevel.recursion.cls;

public class BasicPermutation {
    public static void main(String[] args) {
        String input = "a1b2";
        StringBuilder builder = new StringBuilder();
        basicPermutationHelper(input, 0, builder);

    }

    public static void basicPermutationHelper(String input, int level, StringBuilder builder){

        if(level == input.length()){
            System.out.println(builder.toString());
        } else {
            if(!Character.isDigit(input.charAt(level))){
                builder.append(Character.toLowerCase(input.charAt(level)));
                basicPermutationHelper(input, level+1, builder);
                builder.deleteCharAt(builder.length()-1);

                builder.append(Character.toUpperCase(input.charAt(level)));
                basicPermutationHelper(input, level+1, builder);
                builder.deleteCharAt(builder.length()-1);

            } else{
                builder.append(input.charAt(level));
                basicPermutationHelper(input, level+1, builder);
                builder.deleteCharAt(builder.length()-1);
            }


        }

    }
}
