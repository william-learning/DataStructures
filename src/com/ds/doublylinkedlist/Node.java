package com.ds.doublylinkedlist;

public class Node<T> {
    private T val;
    private Node prev;
    private Node next;

    public Node(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
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
