package playground.CircularBuffer;

public class TestCircularBuffer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CircularBuffer testBuffer = new CircularBuffer(4);

        testBuffer.add("Ajay");
        testBuffer.add("Mahendru");

        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("Anu");
        testBuffer.add("Jagtap");
        testBuffer.add("playground");
        testBuffer.add("one");
        testBuffer.add("two");
        testBuffer.add("three");
        testBuffer.add("four");
        testBuffer.add("five");
        testBuffer.add("six");
        testBuffer.add("seven");
        testBuffer.add("eight");

        testBuffer.print();

        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("one");

        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("two");
        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("three");
        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("four");
        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("five");
        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();


        System.out.println("Removed element: " + testBuffer.remove());
        testBuffer.print();

        testBuffer.add("two");
        testBuffer.add("three");
        testBuffer.add("four");
        testBuffer.add("five");
        testBuffer.add("six");
        testBuffer.add("seven");
        testBuffer.add("eight");
        testBuffer.add("nine");

        testBuffer.print();


    }

}
