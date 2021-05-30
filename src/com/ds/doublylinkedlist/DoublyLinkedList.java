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
        final Node newNode = new Node<>(val);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }

        this.length++;
        return this;
    }

    // Edge case: If the length is equal to 0, return null
    // Store the tail in a temp variable called poppedNode
    // Edge case: If the length is 1, set the head and tail to be null
    // Otherwise, update the tail to be the prev node of the old tail
    // Set the new tail's next to null
    // Set the poppedNode's prev to null
    // Decrement the length
    // Return the node
    public Node pop() {
        if (this.length == 0) {
            return null;
        }

        final Node poppedNode = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = poppedNode.getPrev();
            this.tail.setNext(null);
            poppedNode.setPrev(null);
        }

        this.length--;
        return poppedNode;
    }

    // Edge case: If length is equal to 0, return null
    // Store the current head in shiftedNode
    // Edge case: If length is equal to 1, set the head and tail to null
    // Otherwise, update the head to be the next of shiftedNode
    // Set head's prev to null
    // Set shiftedNode's next to null
    // Decrement the length
    // Return the node
    public Node shift() {
        if (this.length == 0) {
            return null;
        }

        final Node shiftedNode = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = shiftedNode.getNext();
            this.head.setPrev(null);
            shiftedNode.setNext(null);
        }

        this.length--;
        return shiftedNode;
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
