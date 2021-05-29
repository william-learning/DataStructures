package com.ds.doublylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}