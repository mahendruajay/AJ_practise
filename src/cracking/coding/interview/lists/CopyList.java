package cracking.coding.interview.lists;

public class CopyList {

    public static void main(String[] args) {

        RandomNode node1 = new RandomNode(1);
        RandomNode node2 = new RandomNode(2);
        RandomNode node3 = new RandomNode(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node2;

        RandomNode result = copyList(node1);
        System.out.println("Result is: " + result);

    }

    public static RandomNode copyList(RandomNode root) {
        RandomNode n = root;

        while (n != null) {
            RandomNode temp = new RandomNode(n.val);
            temp.next = n.next;
            n.next = temp;
            n = n.next.next;
        }

        n = root;
        while (n != null) {
            n.next.random = n.random.next;
            n = n.next.next;
        }


        RandomNode firstStart = null;
        RandomNode firstEnd = null;
        RandomNode secondStart = null;
        RandomNode secondEnd = null;

        n = root;

        while (n != null) {

            RandomNode next = n.next;

            if (firstStart == null) {
                firstStart = n;
                firstEnd = firstStart;
            } else {
                firstEnd.next = n;
                firstEnd = n;
            }

            if (secondStart == null) {
                secondStart = next;
                secondEnd = secondStart;
            } else {
                secondEnd.next = next;
                secondEnd = next;
            }
            n = next.next;


        }

        firstEnd.next = null;

        return secondStart;
    }


}
