package com.ds.singlylinkedlist;

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
        final Node newNode = new Node<>(val);

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
        final Node newNode = new Node<>(val);

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

    // Function accepts an index as argument
    // Edge case: If the index is less than 0 or greater than or equal to the length of the list, return null
    // Loop through the list until the index is reached
    // Return the node at that index
    public Node get(final int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    // Accepts an index to set and a value
    // Use get() method to retrieve node at index
    // If node is not found, return false
    // If node is found, set the value of the node to the value provided and return true
    public <T> boolean set(final int index, final T val) {
        if (index < 0 || index >= this.length) {
            return false;
        } else {
            final Node node = get(index);
            node.setVal(val);
            return true;
        }
    }

    // Edge case: If index is less than 0 or greater than the length, return false
    // Edge case: If index is equal to 0, unshift a new node to the start of the list
    // Edge case: If index is equal to length, push a new node to end of the list
    // Otherwise, use the get method to access the node at index - 1
    // Set the next property on that node to be the new node
    // Set the next property on the new node to be the previous next
    // Increment the length
    // Return true
    public <T> boolean insert(final int index, final T val) {
        if (index < 0 || index > this.length) {
            return false;
        } else if (index == 0) {
            unshift(val);
            return true;
        } else if (index == this.length) {
            push(val);
            return true;
        } else {
            final Node previousNode = get(index - 1);
            final Node newNode = new Node<>(val);

            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
            this.length++;
            return true;
        }
    }

    // Edge case: If index is less than 0 or greater than or equal to length, return null
    // Edge case: If index is equal to 0, shift
    // Edge case: If index is equal to length - 1, pop
    // Otherwise, use the get() method to access the node at index - 1
    // Set the next property of that node to next property of next node
    // Set the next property of next node to null
    // Decrement the length
    // Return the value of the node to be removed
    public Node remove(final int index) {
        if (index < 0 || index >= this.length) {
            return null;
        } else if (index == 0) {
            return shift();
        } else if (index == this.length - 1) {
            return pop();
        } else {
            final Node previousNode = get(index - 1);
            final Node currentNode = previousNode.getNext();

            previousNode.setNext(currentNode.getNext());
            currentNode.setNext(null);
            this.length--;
            return currentNode;
        }
    }

    // Edge case: If length is equal to 0, return list
    // Edge case: If length is equal to 1, return list

    // Otherwise, set head to be tail and tail to be head
    // Create and set currentNode to old head
    // Create and set previousNode to null
    // Create nextNode

    // Loop through the list while counter is less than the length
    // Set nextNode to currentNode's next node
    // Set currentNode's next node to previousNode
    // Set previousNode to currentNode
    // Set currentNode to nextNode
    public SinglyLinkedList reverse() {
        if (this.length > 1) {
            Node currentNode = this.head;
            this.head = this.tail;
            this.tail = currentNode;

            // Initialise reverse
            Node previousNode = null;
            Node nextNode;

            for (int i = 0; i < this.length; i++) {
                nextNode = currentNode.getNext();
                currentNode.setNext(previousNode);
                previousNode = currentNode;
                currentNode = nextNode;
            }
        }

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
