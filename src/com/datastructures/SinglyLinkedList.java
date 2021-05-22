package com.datastructures;

public class SinglyLinkedList {
    Node head;
    Node tail;
    int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // Create a new node using the value passed to the function
    // If there is no head, set the head and tail to be the newly created node
    // Otherwise, set next property on the tail to be the newly created node
    // Set the tail property to be the newly created node
    // Increment length by 1
    public <T> SinglyLinkedList push(final T val) {
        final Node newNode = new Node(val);

        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.length++;
        return this;
    }

    @Override
    public String toString() {
        return head != null ? head.toString() : "";
    }
}
