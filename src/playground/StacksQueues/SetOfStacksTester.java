package playground.StacksQueues;

public class SetOfStacksTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SetOfStacks stackSet = new SetOfStacks(3);

        stackSet.push(1);
        stackSet.push(2);
        stackSet.push(3);

        stackSet.push(4);
        stackSet.push(5);
        stackSet.push(6);

        stackSet.push(7);
        stackSet.push(8);
        stackSet.push(9);

        // try
        // {
        // System.out.println(stackSet.pop());
        // } catch (StackEmptyException e)
        // {
        // System.out.println(e.getMessage());
        // }

        try {
            System.out.println(stackSet.popAt(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stackSet.print();

    }

}
