package org.start.linked.lists;

public class Node<E extends Comparable> {

    private Node next;
    private E data;


    public Node(E data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public E getData() {
        return this.data;
    }
}
