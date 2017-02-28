package com.playground.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    Node head;
    Node tail;

    LinkedList() {

    }

    public Node buildList(int[] listData) {
        for (int i = 0; i < listData.length; i++) {
            Node newNode = new Node(listData[i]);
            this.addNode(newNode);
        }

        return head;
    }

    public void addNode(Node node) {
        if (null == head) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public Node removeFirst() {
        Node temp = head;
        head = head.getNext();

        if (null == head) {
            tail = head;
        }

        return temp;
    }

    public Node removeLast() {
        return null;
    }

    public void reverseList() {
        Node n = head;
        Node revList = null;

        while (n != null) {
            Node temp = n;
            n = n.getNext();

            temp.setNext(revList);
            revList = temp;
        }

        head = revList;

    }

    public void reverseAdjacent() {
        Node curr = head;
        Node head2 = null;
        Node temp1 = null;
        Node temp2 = null;
        Node prev = null;

        while (curr != null && curr.getNext() != null) {
            temp1 = curr.getNext();
            temp2 = curr.getNext().getNext();

            curr.getNext().setNext(curr);
            curr.setNext(temp2);

            if (prev == null) {
                head2 = temp1;
            }
            if (prev != null) {
                prev.setNext(temp1);
            }

            prev = curr;
            curr = temp2;

        }

        if (head2 != null) {
            head = head2;
        }
    }

    public void printList() {
        Node n = head;

        while (n != null) {
            if (null == n.getNext()) {
                System.out.print(n.getData());
            } else {
                System.out.print(n.getData() + "->");
            }
            n = n.getNext();
        }

        System.out.println();
    }

    public void removeDuplicates1() {
        Node outer = head;

        while (outer != null) {
            int key = outer.getData();
            Node prev = outer;
            Node inner = outer.getNext();

            while (inner != null) {
                if (inner.getData() == key) {
                    prev.setNext(inner.getNext());
                } else {
                    prev = inner;
                }

                inner = inner.getNext();
            }

            outer = outer.getNext();
        }
    }

    public void removeDuplicates2() {
        Set<Integer> listSet = new HashSet<Integer>();

        Node n = head;
        listSet.add(n.getData());

        Node prev = n;
        n = n.getNext();

        while (n != null) {
            if (listSet.contains(n.getData())) {
                prev.setNext(n.getNext());
            } else {
                listSet.add(n.getData());
                prev = n;
            }

            n = n.getNext();
        }
    }

    public Node kthToLastElement(int k) {
        Node n = head;

        for (int i = 0; i < k - 1; i++) {
            if (n == null) {
                return n;
            } else {
                n = n.getNext();
            }
        }

        Node m = head;

        while (n.getNext() != null) {
            n = n.getNext();
            m = m.getNext();
        }

        return m;
    }

    public Node partition(int key) {
        Node n = head;
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        while (n != null) {
            Node temp = n;
            n = n.getNext();
            temp.setNext(null);

            if (temp.getData() <= key) {
                list1.addNode(temp);
            } else {
                list2.addNode(temp);
            }

        }

        return mergeTwoLists(list1, list2);

    }

    public Node mergeTwoLists(LinkedList list1, LinkedList list2) {
        if (list1.tail != null) {
            list1.tail.setNext(list2.head);
        }

        return list1.head;
    }

    /**
     * Recursive add
     *
     * @param n1
     * @param n2
     * @param carry
     * @return
     */
    public ResultNode addDigits(Node n1, Node n2, int carry) {
        Node n = new Node();

        ResultNode temp = null;

        if (n1.getNext() != null && n2.getNext() != null) {
            temp = addDigits(n1.getNext(), n2.getNext(), carry);
        }

        if (temp == null) {
            carry = 0;
        } else {
            carry = temp.getCarry();
        }

        int result = n1.getData() + n2.getData() + carry;
        carry = result / 10;
        int digit = result % 10;

        n.setData(digit);

        if (null != temp) {
            n.setNext(temp.getResult());
        } else {
            n.setNext(null);
        }

        return new ResultNode(n, carry);
    }

    public void reversePrint() {
        reversePrint1(head);
    }

    private void reversePrint1(Node head) {
        if (head == null) {
            return;
        }

        reversePrint1(head.getNext());
        System.out.print(head.getData() + " ");

    }

    public ResultNode addDigitsAlt(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        } else {
            ResultNode temp = addDigitsAlt(n1.getNext(), n2.getNext());

            int carry = 0;

            if (temp != null) {
                carry = temp.getCarry();
            }

            int result = n1.getData() + n2.getData() + carry;
            int digit = result % 10;
            carry = result / 10;

            Node n = new Node();
            n.setData(digit);
            if (null != temp) {
                n.setNext(temp.getResult());
            } else {
                n.setNext(null);
            }

            ResultNode res = new ResultNode(n, carry);

            return res;

        }
    }

}
