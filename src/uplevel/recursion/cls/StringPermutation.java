package uplevel.recursion.cls;


public class StringPermutation {

    public static void main(String[] args) {

        String inp = "abcd";
        stringPermutation(inp.toCharArray(), 0, new StringBuilder());
    }

    public static void stringPermutation(char[] inp, int level, StringBuilder slate){
        if(level == inp.length){
            System.out.println(slate.toString());
        } else{

            for(int i=level; i< inp.length; i++){
                swap(inp, i, level);
                slate.append(inp[level]);
                stringPermutation(inp, level+1, slate);
                slate.deleteCharAt(slate.length() -1);
                swap(inp, i, level);
            }
        }
    }

    public static void swap(char[] input, int first, int second){
        char temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
}
