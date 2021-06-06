package playground.general;

public class SwitchExample {

    enum Color {RED, BLUE}

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub


        //in switch condition can accept - char, short , int , byte , enum
        //In case - only final values , as its resolved at compile time
        final int a = 3;
        final int b = 4;

        String s = "afghgnfggnh";
        switch (s.length()) {


            default:
                System.out.println("default");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case a:
                System.out.println("a");
                break;
            case b:
                System.out.println("b");
                break;


        }


    }

}
