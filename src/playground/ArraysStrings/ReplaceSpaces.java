package playground.ArraysStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Replaces all spaces in a string with '%20'
 *
 * @author ajay
 */
public class ReplaceSpaces {
    /**
     * With Arraylist
     *
     * @param array
     */
    public String replaceSpaces(char[] array) {
        List<Character> myList = new ArrayList<Character>();
        for (char c : array) {
            myList.add(c);
        }

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) == ' ') {
                myList.add(i, '%');
                i++;

                myList.add(i, '2');
                i++;

                myList.add(i, '0');
                i++;

                myList.remove(i);
            }
        }

        return myList.toString();

    }

    public static void main(String[] args) {

        ReplaceSpaces myClass = new ReplaceSpaces();

        String myString = "I am Ajay ";
        char[] myArray = myString.toCharArray();

        int i = 0;
        int j = myArray.length - 1;

        while (i < j) {
            char temp = myArray[i];
            myArray[i] = myArray[j];
            myArray[j] = temp;
            i++;
            j--;
        }

        System.out.println("String reverse is :" + new String(myArray));

        System.out.println(myClass.replaceSpaces(myArray));

    }

}
