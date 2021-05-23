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
    // Return the list
    public <T> SinglyLinkedList push(final T val) {
        final Node newNode = new Node(val);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.length++;
        return this;
    }

    // If there are no nodes on the list, return null
    // Loop through the list until the tail is reached
    // Set the next property of the 2nd last node to be null
    // Set the tail to be the 2nd last node
    // Decrement the length by 1
    // Return the last node
    public Node pop() {
        Node currentNode = this.head;
        Node previousNode = null;

        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return currentNode;
        }

        while (currentNode.getNext() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(null);
        this.tail = previousNode;
        this.length--;

        return currentNode;
    }

    // If there are no nodes, return null
    // Store the current head property in a variable
    // Set the head property to be the current head's next property
    // Decrement the length by 1
    // Return the node removed
    // Edge case: When there is only one node in the list
    public Node shift() {
        final Node currentNode = this.head;

        if (this.length == 0) {
            return null;
        } else if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return currentNode;
        }

        this.head = currentNode.getNext();
        currentNode.setNext(null);
        this.length--;

        return currentNode;
    }

    // Create a new node using the value passed to the function
    // If there is no head, set the head and tail to be the newly created node
    // Otherwise, set next property on the newly created node to be the the current head
    // Set the head property to be the newly created node
    // Increment length by 1
    // Return the list
    public <T> SinglyLinkedList unshift(final T val) {
        final Node newNode = new Node(val);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
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
