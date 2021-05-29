package com.ds.singlylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    SinglyLinkedList list;

    @BeforeEach
    void setup() {
        this.list = new SinglyLinkedList();
        this.list.push("Hi");
        this.list.push("There");
    }

    @Test
    void testPush() {
        this.list.push("SinglyLinkedList");
        assertEquals(this.list.toString(), "HiThereSinglyLinkedList");

        // Test push() for an empty list
        this.list = new SinglyLinkedList();
        this.list.push("SinglyLinkedList");
        assertEquals(this.list.toString(), "SinglyLinkedList");
        assertEquals(this.list.getHead(), this.list.getTail());
        assertEquals(this.list.getLength(), 1);
    }

    @Test
    void testPop() {
        // List will have one more node after popping
        assertEquals(this.list.pop().toString(), "There");
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
        assertEquals(this.list.shift().toString(), "Hi");
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
        this.list.unshift("SinglyLinkedList");
        assertEquals(this.list.toString(), "SinglyLinkedListHiThere");

        // Test unshift() for an empty list
        this.list = new SinglyLinkedList();
        this.list.unshift("SinglyLinkedList");
        assertEquals(this.list.toString(), "SinglyLinkedList");
        assertEquals(this.list.getHead(), this.list.getTail());
        assertEquals(this.list.getLength(), 1);
    }

    @Test
    void testGet() {
        assertEquals(this.list.get(0).toString(), "Hi");
        assertEquals(this.list.get(1).toString(), "There");

        assertNull(this.list.get(-1));
        assertNull(this.list.get(2));
    }

    @Test
    void testSet() {
        assertTrue(this.list.set(0, "Hey"));
        assertTrue(this.list.set(1, "SinglyLinkedList"));
        assertEquals(this.list.toString(), "HeySinglyLinkedList");

        assertFalse(this.list.set(-1, "ShouldNotWork"));
        assertFalse(this.list.set(2, "ShouldNotWork"));
    }

    @Test
    void testInsert() {
        assertTrue(this.list.insert(0, "Hey"));
        assertEquals(this.list.toString(), "HeyHiThere");
        assertEquals(this.list.getLength(), 3);
        assertEquals(this.list.getHead().toString(), "Hey");
        assertEquals(this.list.getTail().toString(), "There");

        assertTrue(this.list.insert(1, "There"));
        assertEquals(this.list.toString(), "HeyThereHiThere");
        assertEquals(this.list.getLength(), 4);
        assertEquals(this.list.getHead().toString(), "Hey");
        assertEquals(this.list.getTail().toString(), "There");

        assertTrue(this.list.insert(2, "List"));
        assertEquals(this.list.toString(), "HeyThereListHiThere");
        assertEquals(this.list.getLength(), 5);
        assertEquals(this.list.getHead().toString(), "Hey");
        assertEquals(this.list.getTail().toString(), "There");

        assertTrue(this.list.insert(5, "SinglyLinkedList"));
        assertEquals(this.list.toString(), "HeyThereListHiThereSinglyLinkedList");
        assertEquals(this.list.getLength(), 6);
        assertEquals(this.list.getHead().toString(), "Hey");
        assertEquals(this.list.getTail().toString(), "SinglyLinkedList");

        assertFalse(this.list.insert(-1, "ShouldNotWork"));
        assertFalse(this.list.insert(7, "ShouldNotWork"));
    }

    @Test
    void testRemove() {
        assertTrue(this.list.insert(0, "Hey"));
        assertTrue(this.list.insert(1, "There"));
        assertTrue(this.list.insert(2, "List"));
        assertTrue(this.list.insert(5, "SinglyLinkedList"));
        assertEquals(this.list.toString(), "HeyThereListHiThereSinglyLinkedList");

        assertEquals(this.list.remove(0).toString(), "Hey");
        assertEquals(this.list.toString(), "ThereListHiThereSinglyLinkedList");

        assertEquals(this.list.remove(4).toString(), "SinglyLinkedList");
        assertEquals(this.list.toString(), "ThereListHiThere");

        assertEquals(this.list.remove(0).toString(), "There");
        assertEquals(this.list.unshift("Linked").toString(), "LinkedListHiThere");

        assertEquals(this.list.remove(2).toString(), "Hi");
        assertEquals(this.list.toString(), "LinkedListThere");

        assertEquals(this.list.getLength(), 3);
        assertEquals(this.list.getHead().toString(), "Linked");
        assertEquals(this.list.getTail().toString(), "There");

        assertNull(this.list.remove(-1));
        assertNull(this.list.remove(3));
    }

    @Test
    void testReverse() {
        assertEquals(this.list.reverse().toString(), "ThereHi");
        assertEquals(this.list.getHead().toString(), "There");
        assertEquals(this.list.getTail().toString(), "Hi");

        setup();
        this.list.push("Singly");
        this.list.push("Linked");
        this.list.push("List");
        assertEquals(this.list.toString(), "HiThereSinglyLinkedList");

        assertEquals(this.list.reverse().toString(), "ListLinkedSinglyThereHi");
        assertEquals(this.list.getHead().toString(), "List");
        assertEquals(this.list.getTail().toString(), "Hi");
        assertEquals(this.list.getLength(), 5);

        this.list = new SinglyLinkedList();
        assertEquals(this.list.reverse().toString(), "");
        assertNull(this.list.getHead());
        assertNull(this.list.getTail());
        assertEquals(this.list.getLength(), 0);

        this.list = new SinglyLinkedList();
        this.list.push("Hi");
        assertEquals(this.list.reverse().toString(), "Hi");
        assertEquals(this.list.getHead(), this.list.getTail());
        assertEquals(this.list.getHead().toString(), "Hi");
        assertEquals(this.list.getLength(), 1);
    }
}