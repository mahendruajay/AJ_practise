package cracking.coding.interview.lists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList<E extends Comparable<? super E>> {

    private Node head;
    private Node tail;

    public LinkedList() {

    }

    public LinkedList(E[] listData) {
        buildList(listData);
    }

    private void buildList(E[] listData) {
        for (E data : listData) {
            Node<E> n = new Node(data);
            append(n);
        }
    }

    private void append(Node<E> node) {
        if (null == head) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    private void addToStart(Node<E> node) {
        if (null == head) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public void printList() {
        Node tempHead = head;
        StringBuilder listBuilder = new StringBuilder();

        while (tempHead != null) {
            listBuilder.append(tempHead.getData());
            listBuilder.append("->");
            tempHead = tempHead.getNext();
        }
        listBuilder.append("NULL");

        System.out.println(listBuilder.toString());
    }

    public void removeDuplicatesUsingLoop() {
        Node stable = head;

        while (stable != null) {
            Node runner = stable.getNext();
            Node prev = stable;

            while (runner != null) {
                if (stable.getData().equals(runner.getData())) {
                    prev.setNext(runner.getNext());
                    runner.setNext(null);
                    runner = prev.getNext();
                } else {
                    prev = runner;
                    runner = runner.getNext();
                }
            }
            stable = stable.getNext();
        }
    }

    public void removeDuplicatesUsingSet() {
        Set<E> visitedNodes = new HashSet<>();

        Node<E> n = head;
        Node<E> prev = head;

        while (n != null) {
            if (visitedNodes.contains(n.getData())) {
                prev.setNext(n.getNext());
                n.setNext(null);
                n = prev.getNext();
            } else {
                visitedNodes.add(n.getData());
                prev = n;
                n = n.getNext();
            }
        }

    }

    public E kthToLastElement(int k) {
        Node<E> n = head;
        for (int i = 1; i < k; i++) {
            if (null == n) break;
            n = n.getNext();
        }
        Node<E> m = head;
        if (null != n) {
            while (n.getNext() != null) {
                n = n.getNext();
                m = m.getNext();
            }
        }

        return m.getData();

    }

    public E kthToLastElementRecursive(int k) {
        kthToTheLastResult<E> kthToTheLastResult = kthToLastElementRec(head, k, new kthToTheLastResult<E>());
        return kthToTheLastResult.node.getData();

    }

    private kthToTheLastResult<E> kthToLastElementRec(Node<E> head, int k, kthToTheLastResult<E> result) {
        if (head == null) {
            return result;
        } else {
            result = kthToLastElementRec(head.getNext(), k, result);
            result.setIndex(result.getIndex() + 1);
            if (result.getIndex() == k) {
                result.setNode(head);
                return result;
            }
        }

        return result;
    }


    public void partitionAroundX(E data) {

        LinkedList<E> linkedList = new LinkedList<>();
        while (head != null) {

            if (head.getData().compareTo(data) == 1 || head.getData().compareTo(data) == 0) {
                Node<E> temp = head;
                head = head.getNext();
                temp.setNext(null);
                linkedList.append(temp);
            } else {
                Node<E> temp = head;
                head = head.getNext();
                temp.setNext(null);
                linkedList.addToStart(temp);
            }

            printList();
            linkedList.printList();
        }

        printList();
        linkedList.printList();

    }

    public void printListReverse() {

        StringBuilder builder = new StringBuilder();
        printRev(head, builder);
        builder.append("NULL");
        System.out.println(builder.toString());
    }


    private void printRev(Node<E> head, StringBuilder builder) {
        if (head == null) {
            return;
        }
        printRev(head.getNext(), builder);
        builder.append(head.getData() + "->");
    }

    public boolean checkPalindromeUsingSet() {
        Stack<E> nodeStack = new Stack<>();

        Node<E> slow = head;
        Node<E> fast = head;

        while (fast != null && fast.getNext() != null) {
            nodeStack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            E data = nodeStack.pop();
            if (data.compareTo(slow.getData()) != 0) {
                return false;
            }
            slow = slow.getNext();
        }

        return true;
    }


    public boolean checkPalindromeRecursive() {
        PalResult<E> palResult = new PalResult();
        palResult = checkPalRec(head, palResult, getLength());
        return palResult.isPal();

    }

    private PalResult<E> checkPalRec(Node<E> head, PalResult palResult, int len) {

        if (head == null || len <= 0) {
            palResult.setNodeToCompare(head);
            palResult.setPal(true);
            return palResult;
        } else if (len == 1) {
            palResult.setNodeToCompare(head.getNext());
            palResult.setPal(true);
            return palResult;
        }

        palResult = checkPalRec(head.getNext(), palResult, len - 2);
        boolean res = palResult.getNodeToCompare().getData().compareTo(head.getData()) == 0;
        palResult.setPal(palResult.isPal() && res);
        palResult.setNodeToCompare(palResult.getNodeToCompare().getNext());

        return palResult;
    }

    public int getLength() {
        Node<E> n = head;
        int length = 0;
        while (n != null) {
            length++;
            n = n.getNext();
        }
        return length;
    }


    public LinkedList reverseAndClone() {
        LinkedList<E> reverse = new LinkedList<E>();
        Node<E> n = head;

        while (n != null) {

            Node<E> node = new Node<>(n.getData());
            reverse.addToStart(node);

            n = n.getNext();
        }

        return reverse;

    }

    private void padList(int padLen) {
        while (padLen > 3) {
            Node<E> node = new Node<E>(null);
            this.addToStart(node);
        }

    }

    public class PalResult<E extends Comparable> {
        private Node<E> nodeToCompare;
        private boolean isPal;

        public Node<E> getNodeToCompare() {
            return nodeToCompare;
        }

        public void setNodeToCompare(Node<E> nodeToCompare) {
            this.nodeToCompare = nodeToCompare;
        }

        public boolean isPal() {
            return isPal;
        }

        public void setPal(boolean pal) {
            isPal = pal;
        }
    }

    public class kthToTheLastResult<E extends Comparable> {

        private Node<E> node;
        private int index = 0;

        public Node<E> getNode() {
            return node;
        }

        public void setNode(Node<E> node) {
            this.node = node;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

    public class Sum<E extends Comparable<? super E>> {
        LinkedList<E> resultList = new LinkedList<>();
        int carry = 0;

        public LinkedList<E> getResultList() {
            return resultList;
        }

        public int getCarry() {
            return carry;
        }

        public void setCarry(int carry) {
            this.carry = carry;
        }
    }
}
