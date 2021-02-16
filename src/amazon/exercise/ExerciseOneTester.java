package amazon.exercise;

/**
 * This class provides playground cases for ExerciseOne
 *
 * @author anu
 */
public class ExerciseOneTester {

    /**
     * @param args
     */
    public static void main(String[] args) {


        InputStream ip = new InputStream(null);
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());

        ip = new InputStream("");
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());


        ip = new InputStream("aaaa");
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());


        ip = new InputStream("aabbc");
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());


        ip = new InputStream("aabbcaabbc");
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());


        ip = new InputStream("daabbcaabbc");
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());

        ip = new InputStream("aabbcaabbcgfhjtodyihjtiohyithjsaaaaaaaaaaaaaaaaaaaaaaaaaaaoerjgtojerogtjtorj");
        System.out.println("First unique char  :  " + ip.getFirstNonRepeatedChar());


    }

}
