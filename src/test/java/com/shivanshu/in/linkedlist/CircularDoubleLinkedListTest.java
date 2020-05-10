package com.shivanshu.in.linkedlist;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CircularDoubleLinkedListTest {
    @Test
    public void testSize() {
        CircularDoubleLinkedList<Integer> testList = new CircularDoubleLinkedList<Integer>();
        assertEquals(testList.size(), 0);
        testList.insertFirst(3);
        assertEquals(testList.size(), 1);
    }

    @Test
    public void testInsertFirst() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("New");
        assertEquals(testList.size(), 1);
        testList.insertFirst("Latest");
        assertEquals(testList.size(), 2);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testGetFirstInEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<Integer> testList = new CircularDoubleLinkedList<Integer>();
        testList.getFirst();
    }

    @Test
    public void testGetFirst() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("He");
        assertEquals(testList.getFirst(), "He");
        testList.insertFirst("She");
        assertEquals(testList.getFirst(), "She");
    }

    @Test
    public void testInsertLast() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertLast("He");
        assertEquals(testList.size(), 1);
        testList.insertLast("She");
        assertEquals(testList.size(), 2);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testGetLastEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        assertEquals(testList.getLast(), "unique");
    }

    @Test
    public void testGetLast() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("I");
        testList.insertLast("am");
        testList.insertFirst("unique");
        assertEquals(testList.getLast(), "am");
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testGetEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        assertEquals("I", testList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBound() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("I");
        testList.insertLast("am");
        assertEquals("I", testList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetBelowBound() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("I");
        testList.insertLast("am");
        assertEquals("I", testList.get(-1));
    }

    @Test
    public void testGetList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("I");
        testList.insertLast("am");
        testList.insertFirst("unique");
        assertEquals("I", testList.get(1));
        assertEquals("am", testList.get(2));
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDestroy() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("Everyone");
        testList.insertLast("is");
        testList.insertFirst("unique");
        testList.destroy();
        testList.get(0);
    }

    @Test
    public void testEmptyListContain() {
        CircularDoubleLinkedList<Integer> testList = new CircularDoubleLinkedList<Integer>();
        assertFalse(testList.contain(1));
    }

    @Test
    public void testPositiveContain() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("Everyone");
        testList.insertLast("is");
        testList.insertFirst("unique");
        assertTrue(testList.contain("Everyone"));
        assertTrue(testList.contain("unique"));
        assertTrue(testList.contain("is"));
    }

    @Test
    public void testNegativeContainEmptyList() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        assertFalse(testList.contain("Everyone"));
    }

    @Test
    public void testNegativeContain() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insertFirst("Everyone");
        testList.insertLast("is");
        testList.insertFirst("unique");
        assertFalse(testList.contain("Not"));
    }

    @Test
    public void testInsertAtZeroPosition() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("str1", 0);
        assertEquals(testList.get(0), "str1");
        assertEquals(testList.size(), 1);
        testList.insert("str2", 0);
        assertEquals(testList.get(0), "str2");
        assertEquals(testList.size(), 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtNegative() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("str1", 0);
        testList.insert("str1", -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtOutOfBound() {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("str1", 0);
        testList.insert("str1", 2);
    }

    @Test
    public void testInsertAtLast() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("str0", 0);
        testList.insert("str1", 1);
        testList.insert("str2", 2);
        assertEquals(testList.size(), 3);
        assertEquals(testList.get(2), "str2");
    }

    @Test
    public void testInsertAtPosition() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("str0", 0);
        testList.insert("str2", 1);
        testList.insert("str1", 1);
        assertEquals(3, testList.size());
        assertEquals(testList.get(1), "str1");
        assertEquals(testList.get(2), "str2");
    }

    @Test
    public void testInsert() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("First");
        assertEquals(testList.size(), 1);
        assertEquals(testList.get(0), "First");
        testList.insert("Second");
        assertEquals(2, testList.size());
        assertEquals("Second", testList.get(1));
    }

    @Test
    public void testDeleteFirst() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("First");
        testList.insert("Second");
        testList.insert("Third");
        assertEquals(testList.size(), 3);
        assertTrue(testList.contain("First"));
        testList.deleteFirst();
        assertFalse(testList.contain("First"));
        assertTrue(testList.contain("Second"));
        testList.deleteFirst();
        assertFalse(testList.contain("Second"));
        assertEquals(testList.size(), 1);
        assertTrue(testList.contain("Third"));
        testList.deleteFirst();
        assertFalse(testList.contain("Third"));
        assertEquals(testList.size(), 0);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteFirstInEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.deleteFirst();
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteLastInEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.deleteLast();
    }

    @Test
    public void testDeleteLast() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("First");
        testList.insert("Second");
        testList.insert("Third");
        assertEquals(testList.size(), 3);
        assertTrue(testList.contain("Third"));
        testList.deleteLast();
        assertFalse(testList.contain("Third"));
        assertTrue(testList.contain("Second"));
        testList.deleteLast();
        assertFalse(testList.contain("Second"));
        assertEquals(testList.size(), 1);
        assertTrue(testList.contain("First"));
        testList.deleteLast();
        assertFalse(testList.contain("First"));
        assertEquals(testList.size(), 0);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteEmptyInEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.delete("NoElement");
    }

    @Test
    public void testDelete() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("First");
        testList.insert("Second");
        testList.insert("Third");
        assertEquals(testList.size(), 3);
        assertTrue(testList.contain("Third"));
        testList.delete("Third");
        assertFalse(testList.contain("Third"));
        assertTrue(testList.contain("Second"));
        testList.deleteLast();
        assertFalse(testList.contain("Second"));
        assertEquals(testList.size(), 1);
        assertTrue(testList.contain("First"));
        testList.delete("First");
        assertFalse(testList.contain("First"));
        assertEquals(testList.size(), 0);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteIntPositionEmptyList() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.delete(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOutOfBound() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("I love my country");
        testList.insert("I love my earth");
        testList.delete(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteInBound() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("I love my country");
        testList.insert("I love my earth");
        testList.delete(-1);
    }

    @Test
    public void testDeleteInPosition() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("I love my country");
        testList.insert("I love my earth");
        testList.insert("I love coding");
        testList.insert("I love instagram");
        testList.insert("I love facebook");
        testList.insert("I love yoga");
        testList.insert("I love pet");
        testList.delete(3);
        testList.delete(3);
        assertFalse(testList.contain("I love instagram"));
        assertFalse(testList.contain("I love facebook"));
        assertEquals(testList.size(), 5);
        testList.delete(4);
        assertFalse(testList.contain("I love pet"));
        assertEquals(4, testList.size());
    }

    @Test
    public void testCircularity() throws EmptyLinkedListException {
        CircularDoubleLinkedList<String> testList = new CircularDoubleLinkedList<String>();
        testList.insert("a");
        testList.insert("b");
        testList.insert("c");
        testList.insert("d");

        CircularDoubleLinkedList<String>.DoubleLinkedListIterator<String> iterator = testList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasPrevious());
        assertEquals("d", iterator.previous());
         assertTrue(iterator.hasPrevious());
        assertEquals("c", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals("b", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals("a", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
    }
}