package cracking.coding.interview.practice20.arrays_and_strings;

public class URLify {

    public static void main(String[] args) {

        String inp = "Mr John Smith    ";
        char[] input = inp.toCharArray();
        System.out.println("Urlified string is :" + urlify(input, 13));
    }

    public static String urlify(char[] input, int trueLength){
        int dest =input.length-1;
        int i = trueLength-1;
        while(i>=0){
            if(input[i] == ' '){
                input[dest] = '0';
                dest--;
                input[dest] = '2';
                dest--;
                input[dest] = '%';
                dest--;
            }
            else {
                input[dest] = input[i];
                dest--;
            }
            i--;
        }
        return new String(input);
    }
}
