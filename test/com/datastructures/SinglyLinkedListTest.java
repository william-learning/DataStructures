package com.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        // Test push() for an empty list
        list = new SinglyLinkedList();
        list.push("SinglyLinkedList");
        assertEquals(list.toString(), "SinglyLinkedList");
        assertEquals(list.getHead(), list.getTail());
        assertEquals(list.getLength(), 1);
    }

    @Test
    void testPop() {
        // List will have one more node after popping
        assertEquals(list.pop().toString(), "There");
        assertEquals(list.getHead(), list.getTail());

        // List will be empty after popping final node
        assertEquals(list.pop().toString(), "Hi");
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(list.getLength(), 0);

        // Popping an empty list should result in a null value returned
        assertNull(list.pop());
    }

    @Test
    void testShift() {
        // List will have one more node after shifting
        assertEquals(list.shift().toString(), "Hi");
        assertEquals(list.getHead(), list.getTail());

        // List will be empty after shifting final node
        assertEquals(list.shift().toString(), "There");
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(list.getLength(), 0);

        // Shifting an empty list should result in a null value returned
        assertNull(list.shift());
    }

    @Test
    void testUnshift() {
        list.unshift("SinglyLinkedList");
        assertEquals(list.toString(), "SinglyLinkedListHiThere");

        // Test unshift() for an empty list
        list = new SinglyLinkedList();
        list.unshift("SinglyLinkedList");
        assertEquals(list.toString(), "SinglyLinkedList");
        assertEquals(list.getHead(), list.getTail());
        assertEquals(list.getLength(), 1);
    }

    @Test
    void testGet() {
        assertEquals(list.get(0).toString(), "Hi");
        assertEquals(list.get(1).toString(), "There");

        assertNull(list.get(-1));
        assertNull(list.get(2));
    }

    @Test
    void testSet() {
        assertTrue(list.set(0, "Hey"));
        assertTrue(list.set(1, "SinglyLinkedList"));
        assertEquals(list.toString(), "HeySinglyLinkedList");

        assertFalse(list.set(-1, "ShouldNotWork"));
        assertFalse(list.set(2, "ShouldNotWork"));
    }
}