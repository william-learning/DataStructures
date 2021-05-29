package com.ds.doublylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DoublyLinkedListTest {

    DoublyLinkedList list;

    @BeforeEach
    void setup() {
        this.list = new DoublyLinkedList();
        this.list.push("Hi");
        this.list.push("There");
    }

    @Test
    void testPush() {
        this.list.push("DoublyLinkedList");
        assertEquals(this.list.toString(), "HiThereDoublyLinkedList");

        assertEquals(this.list.getTail().getPrev().toString(), "There");
        assertEquals(this.list.getTail().getPrev().getNext().toString(), "DoublyLinkedList");

        assertEquals(this.list.getHead().toString(), "Hi");
        assertEquals(this.list.getTail().toString(), "DoublyLinkedList");
        assertEquals(this.list.getLength(), 3);

        // Test push() for an empty list
        this.list = new DoublyLinkedList();
        this.list.push("DoublyLinkedList");
        assertEquals(this.list.toString(), "DoublyLinkedList");
        assertEquals(this.list.getHead(), this.list.getTail());
        assertEquals(this.list.getLength(), 1);
    }

    @Test
    void testPop() {
        // List will have one more node after popping
        Node poppedNode = this.list.pop();
        assertEquals(poppedNode.toString(), "There");
        assertNull(poppedNode.getNext());
        assertNull(poppedNode.getPrev());
        assertEquals(this.list.getHead(), this.list.getTail());

        // List will be empty after popping final node
        assertEquals(this.list.pop().toString(), "Hi");
        assertNull(this.list.getHead());
        assertNull(this.list.getTail());
        assertEquals(this.list.getLength(), 0);

        // Popping an empty list should result in a null value returned
        assertNull(this.list.pop());
    }
}