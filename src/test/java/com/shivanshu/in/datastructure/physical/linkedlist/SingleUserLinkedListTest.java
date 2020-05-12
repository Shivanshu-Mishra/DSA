package com.shivanshu.in.datastructure.physical.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class SingleUserLinkedListTest {
    private UserLinkedList testList;

    @Test
    public void testInsert() {
        testList = new SingleUserLinkedList();
        assertTrue(testList.size() == 0);
        testList.insert(10);
        assertTrue(testList.size() == 1);
        testList.insert("10");
        assertTrue(testList.size() == 2);
    }

    @Test
    public void testInsertFirst() throws EmptyLinkedListException {
        testList = new SingleUserLinkedList();
        testList.insertFirst("Hello");
        assertTrue(testList.getFirst().equals("Hello"));
        testList.insertFirst("Hi");
        assertTrue(testList.getFirst().equals("Hi"));
    }

    @Test
    public void testInsertLast() throws EmptyLinkedListException {
        testList = new SingleUserLinkedList();
        testList.insertLast("Hello");
        assertTrue(testList.getLast().equals("Hello"));
        testList.insertLast("Hi");
        assertTrue(testList.getLast().equals("Hi"));
        assertTrue(testList.size() == 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertInNegativePosition() {
        testList = new SingleUserLinkedList();
        testList.insert(1, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBound() {
        testList = new SingleUserLinkedList();
        testList.insert(1);
        testList.insert(2);
        testList.insert(10, 100);
    }

    @Test
    public void testInsertInBound() throws EmptyLinkedListException {
        SingleUserLinkedList<Integer> integerList = new SingleUserLinkedList<Integer>();
        integerList.insert(1);
        integerList.insert(2);
        integerList.insert(4);
        integerList.insert(5);
        integerList.insert(3, 2);
        boolean result = integerList.get(2).equals(3);
        assertTrue(result);
    }

    @Test
    public void testInsertAtFirstPosition() throws EmptyLinkedListException {
        SingleUserLinkedList<Integer> integerList = new SingleUserLinkedList<Integer>();
        integerList.insert(1, 0);
        assertTrue(integerList.get(0).equals(1));
    }

    @Test
    public void testInsertAtLastPosition() throws EmptyLinkedListException {
        SingleUserLinkedList<Integer> integerList = new SingleUserLinkedList<Integer>();
        integerList.insert(1);
        integerList.insert(2, 1);
        assertTrue(integerList.get(1).equals(2));
    }

    @Test
    public void testContain() {
        testList = new SingleUserLinkedList();
        assertFalse(testList.contain(10));
        testList.insert(10);
        assertTrue(testList.contain(10));
        testList.insert("Hello");
        testList.insert(50);
        assertTrue(testList.contain("Hello"));
        assertFalse(testList.contain(900));
    }

    @Test
    public void testGetFirst() throws EmptyLinkedListException {
        testList = new SingleUserLinkedList();
        testList.insert("First");
        assertTrue(testList.getFirst().equals("First"));
        testList.insert(2);
        assertTrue(testList.getFirst().equals("First"));
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testGetFirstException() throws EmptyLinkedListException {
        new SingleUserLinkedList<Boolean>().getFirst();
    }

    @Test
    public void testGetLast() throws EmptyLinkedListException {
        UserLinkedList<Integer> fibonacci = new SingleUserLinkedList<Integer>();
        fibonacci.insert(0);
        assertTrue(fibonacci.getLast() == 0);
        fibonacci.insert(1);
        assertTrue(fibonacci.getLast() == 1);
        fibonacci.insert(1);
        assertTrue(fibonacci.getLast() == 1);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testGetLastException() throws EmptyLinkedListException {
        new SingleUserLinkedList<Boolean>().getLast();
    }

    @Test
    public void testGetIndex() throws EmptyLinkedListException {
        UserLinkedList<Integer> testList = new SingleUserLinkedList();
        testList.insert(0);
        assertTrue(testList.get(0) == 0);
        testList.insert(1);
        testList.insert(2);
        testList.insert(3);
        assertTrue(testList.get(1) == 1);
        assertTrue(testList.get(3) == 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfBound() throws EmptyLinkedListException {
        UserLinkedList<String> testList = new SingleUserLinkedList();
        testList.insert("a");
        testList.insert("b");
        testList.insert("c");
        assertTrue(testList.get(3) == "I m possible");
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testGetIndexEmptyLinkedList() throws EmptyLinkedListException {
        new SingleUserLinkedList().get(0);
    }

    @Test
    public void testContainInEmptyLinkedList() {
        assertFalse(new SingleUserLinkedList<String>().contain("a"));
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteEmptyList() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.delete("Empty");
    }

    @Test
    public void testDelete() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("not"));
        assertEquals(testList.size(), 5);
        testList.delete("not");
        assertFalse(testList.contain("not"));
        assertEquals(testList.size(), 4);
    }

    @Test
    public void testDeleteFirstValue() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("This"));
        assertEquals(testList.size(), 5);
        testList.delete("This");
        assertFalse(testList.contain("This"));
        assertEquals(testList.size(), 4);
    }

    @Test
    public void testDeleteLastValue() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("This"));
        assertEquals(testList.size(), 5);
        testList.delete("This");
        assertFalse(testList.contain("This"));
        assertEquals(testList.size(), 4);
    }

    @Test
    public void testDeleteLast() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("Life"));
        assertEquals(testList.size(), 5);
        testList.deleteLast();
        assertFalse(testList.contain("Life"));
        assertEquals(testList.size(), 4);
    }

    @Test
    public void testDeleteFirst() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("This"));
        assertEquals(testList.size(), 5);
        testList.deleteFirst();
        assertFalse(testList.contain("This"));
        assertEquals(4,testList.size());
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteFirstEmptyList() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.deleteFirst();
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDeleteLastEmptyList() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.deleteLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOutOfBound001() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.delete(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOutOfBound002() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.delete(-1);
    }

    @Test
    public void testDeleteFirstPosition() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("This"));
        assertEquals(testList.size(),5);
        testList.delete(0);
        assertFalse(testList.contain("This"));
        assertEquals(testList.size(),4);
    }

    @Test
    public void testDeleteLastPosition() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("Life"));
        assertEquals(testList.size(),5);
        testList.delete(4);
        assertFalse(testList.contain("Life"));
        assertEquals(testList.size(),4);
    }

    @Test
    public void testDeleteSpecificPosition() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("not");
        testList.insert("my");
        testList.insertLast("Life");
        assertTrue(testList.contain("not"));
        assertEquals(testList.size(),5);
        testList.delete(2);
        assertFalse(testList.contain("not"));
        assertEquals(testList.size(),4);
        assertTrue(testList.contain("my"));
        testList.delete(2);
        assertFalse(testList.contain("my"));
        assertEquals(testList.size(),3);
    }

    @Test
    public void testDestroy001(){
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insertFirst("This");
        testList.insert("is");
        testList.insert("my");
        testList.insertLast("Life");
        testList.destroy();
        assertTrue(testList.size()==0);
    }

    @Test(expected = EmptyLinkedListException.class)
    public void testDestroy002() throws EmptyLinkedListException {
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insertFirst("This");
        testList.insert("is");
        testList.insert("my");
        testList.insertLast("Life");
        testList.destroy();
        testList.getFirst();
    }

    @Test
    public void testTraversal(){
        List<String> expectedList= Arrays.asList("This","is","Single","LinkedList");
        List<String> actualList=new ArrayList<String>();
        SingleUserLinkedList<String> testList = new SingleUserLinkedList<String>();
        testList.insert("This");
        testList.insert("is");
        testList.insert("Single");
        testList.insert("LinkedList");
        Iterator<String> iterator=testList.iterator();
        while(iterator.hasNext()){
            actualList.add(iterator.next());
        }
        assertEquals(expectedList,actualList);
    }
}