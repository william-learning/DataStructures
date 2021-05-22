package com.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }
}