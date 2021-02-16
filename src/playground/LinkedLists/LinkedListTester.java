package playground.LinkedLists;

public class LinkedListTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        int[] arr1 = {3, 7, 4};
        int[] arr2 = {5, 9, 6};

        list1.buildList(arr1);
        list2.buildList(arr2);

        list1.printList();

        // list1.reversePrint();
        // list2.printList();
        //
        // list.reverseList();
        //
        // list.printList();
        //
        // list.reverseAdjacent();

        // list.printList();

        // list.removeDuplicates1();
        //
        // list.printList();

        // list.removeDuplicates2();

        // list.printList();

        // System.out.println(list.kthToLastElement(0).getData());

        // Node n = list.partition(5);
        //
        // while(n != null)
        // {
        // if (null == n.getNext())
        // {
        // System.out.print(n.getData());
        // } else
        // {
        // System.out.print(n.getData() + "->");
        // }
        // n = n.getNext();
        // }

        ResultNode res = list1.addDigitsAlt(list1.head, list2.head);

        Node n = res.getResult();

        while (n != null) {
            if (null == n.getNext()) {
                System.out.print(n.getData());
            } else {
                System.out.print(n.getData() + "->");
            }
            n = n.getNext();
        }

    }
}
