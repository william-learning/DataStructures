package com.ds.singlylinkedlist;

public class Node<T> {
    private T val;
    private Node next;

    public Node(final T val) {
        this.val = val;
        this.next = null;
    }

    public T getVal() {
        return this.val;
    }

    public void setVal(final T val) {
        this.val = val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(final Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }

    public String printAllNodes() {
        final StringBuilder sb = new StringBuilder(this.val.toString());
        if (this.next != null) {
            sb.append(this.next.printAllNodes());
        }
        return sb.toString();
    }
}
