package com.ds.doublylinkedlist;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Create a new node with the new value
    // Edge case: If the length is equal to 0, set the head and tail to be the new node
    // Otherwise, set the next property of the tail to be the new node
    // Set the prev property of the new node to the tail
    // Set the tail to be the new node
    // Increment the length
    // Return the list
    public <T> DoublyLinkedList push(final T val) {
        final Node node = new Node<>(val);

        if (this.length == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }

        this.length++;
        return this;
    }

    @Override
    public String toString() {
        return this.head != null ? this.head.printAllNodes() : "";
    }



    // Accessor methods

    Node getHead() {
        return this.head;
    }

    Node getTail() {
        return this.tail;
    }

    int getLength() {
        return this.length;
    }
}
