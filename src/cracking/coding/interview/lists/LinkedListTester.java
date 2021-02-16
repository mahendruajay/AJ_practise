package cracking.coding.interview.lists;

public class LinkedListTester {

    public static void main(String[] args) {
//        Integer[] list = {4, 2, 9, 4, 2, 6, 1, 5, 1, 3, 3};
        Integer[] list = {4, 2, 3, 3, 2, 4};
//        Integer[] list = {3, 5, 8, 5, 10, 2, 1, 11};
//        Integer[] list = {4, 1};
        LinkedList<Integer> linkedList = new LinkedList<Integer>(list);
        linkedList.printList();
//        linkedList.removeDuplicatesUsingLoop();
//        linkedList.removeDuplicatesUsingSet();
//        System.out.println(linkedList.kthToLastElement(12));
//        linkedList.partitionAroundX(5);

//        linkedList.printListReverse();
//        System.out.println(linkedList.kthToLastElementRecursive(7));
//        System.out.println(linkedList.checkPalindromeUsingSet());
        System.out.println(linkedList.checkPalindromeRecursive());
        linkedList.reverseAndClone().printList();


    }

}
