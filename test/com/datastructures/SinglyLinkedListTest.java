package com.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SinglyLinkedListTest {

    SinglyLinkedList list;

    @BeforeEach
    void setup() {
        list = new SinglyLinkedList();
        list.push("Hi");
        list.push("There");
    }

    @Test
    void testPush() {
        list.push("SinglyLinkedList");
        assertEquals(list.toString(), "HiThereSinglyLinkedList");
    }

    @Test
    void testPop() {
        // List will have one more node after popping
        assertEquals(list.pop().toString(), "There");
        assertEquals(list.getHead(), list.getTail());

        // List will be empty after popping last node
        assertEquals(list.pop().toString(), "Hi");
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(list.getLength(), 0);

        // Popping an empty list should result in a null value returned
        assertNull(list.pop());
    }
}