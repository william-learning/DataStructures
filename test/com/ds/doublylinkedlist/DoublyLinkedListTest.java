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
        final Node poppedNode = this.list.pop();
        assertEquals(poppedNode.toString(), "There");
        assertNull(poppedNode.getNext());
        assertNull(poppedNode.getPrev());
        assertNull(this.list.getTail().getNext());
        assertEquals(this.list.getHead(), this.list.getTail());

        // List will be empty after popping final node
        assertEquals(this.list.pop().toString(), "Hi");
        assertNull(this.list.getHead());
        assertNull(this.list.getTail());
        assertEquals(this.list.getLength(), 0);

        // Popping an empty list should result in a null value returned
        assertNull(this.list.pop());
    }

    @Test
    void testShift() {
        // List will have one more node after shifting
        final Node shiftedNode = this.list.shift();
        assertEquals(shiftedNode.toString(), "Hi");
        assertNull(shiftedNode.getNext());
        assertNull(shiftedNode.getPrev());
        assertNull(this.list.getHead().getPrev());
        assertEquals(this.list.getHead(), this.list.getTail());

        // List will be empty after shifting final node
        assertEquals(this.list.shift().toString(), "There");
        assertNull(this.list.getHead());
        assertNull(this.list.getTail());
        assertEquals(this.list.getLength(), 0);

        // Shifting an empty list should result in a null value returned
        assertNull(this.list.shift());
    }

    @Test
    void testUnshift() {
        this.list.unshift("DoublyLinkedList");
        assertEquals(this.list.toString(), "DoublyLinkedListHiThere");

        assertEquals(this.list.getHead().toString(), "DoublyLinkedList");
        assertEquals(this.list.getHead().getNext().toString(), "Hi");
        assertEquals(this.list.getHead().getNext().getPrev().toString(), "DoublyLinkedList");
        assertEquals(this.list.getLength(), 3);

        // Test unshift() for an empty list
        this.list = new DoublyLinkedList();
        this.list.unshift("DoublyLinkedList");
        assertEquals(this.list.toString(), "DoublyLinkedList");
        assertEquals(this.list.getHead(), this.list.getTail());
        assertEquals(this.list.getLength(), 1);
    }
}