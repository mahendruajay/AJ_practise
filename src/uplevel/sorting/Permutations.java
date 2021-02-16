package uplevel.sorting;

public class Permutations {

    public static void main(String[] args) {
        int[] input = {1,2,3};
        permutationsHelper(input, 0, new StringBuilder());
    }

    public static void permutationsHelper(int[] input, int idx, StringBuilder soFar){

        if(idx == input.length){
            System.out.println(soFar.toString());
        } else {
            for(int i=idx; i< input.length; i++) {
                swap(input, idx, i);
                soFar.append(input[idx]);
                permutationsHelper(input, idx+1, soFar);
                soFar.deleteCharAt(idx);
                swap(input, idx, i);
            }

        }


    }

    public static void swap(int[] input, int first, int second){
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }
}
