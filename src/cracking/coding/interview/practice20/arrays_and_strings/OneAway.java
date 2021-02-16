package cracking.coding.interview.practice20.arrays_and_strings;

public class OneAway {

    public static void main(String[] args) {
        String one = "pale";
        String two = "pala";
        System.out.println("Is One Away: " + oneAway(one, two));
    }

    public static boolean oneAway(String one, String two){

        if (one.length() == two.length()){
            return isOneAwayReplace(one, two);
        }
        String smaller;
        String bigger;
        if(one.length() <= two.length()){
            smaller = one;
            bigger = two;
        }
        else{
            smaller = two;
            bigger = one;
        }
        if(bigger.length() - smaller.length() > 1){
            return false;
        }
        return isOneAwayInsertRemove(bigger, smaller);
    }

    public static boolean isOneAwayReplace(String one, String two){
        boolean found = false;
        for(int i=0; i< one.length(); i++){
            if (one.charAt(i) != two.charAt(i)){
                if (found) {
                    return false;
                }
                else{
                    found = true;
                }
            }
        }

        return true;
    }

    public static boolean isOneAwayInsertRemove(String bigger, String smaller){
        int i = 0;
        int j=0;
        boolean found = false;
        while(i < smaller.length()){
            if (smaller.charAt(i) != bigger.charAt(j)){
                if (found) {
                    return false;
                }
                else{
                    found = true;
                }
                j++;
            } else{
                i++;
                j++;
            }

        }
        return true;

    }
}
