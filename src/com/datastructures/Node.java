package com.datastructures;

public class Node<T> {
    private T val;
    private Node next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(val.toString());
        if (next != null) {
            sb.append(next.toString());
        }
        return sb.toString();
    }
}
