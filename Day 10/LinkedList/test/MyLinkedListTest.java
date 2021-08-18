import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void remove0() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 0;

        String expected = "0";
        String actual = myLinkedList.remove(index);
        assertEquals(expected,actual);
    }
    @Test
    void remove1() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 1;

        String expected = "1";
        String actual = myLinkedList.remove(index);
        assertEquals(expected,actual);
    }
    @Test
    void remove2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 2;

        String expected = "2";
        String actual = myLinkedList.remove(index);
        assertEquals(expected,actual);
    }

    @Test
    void testRemoveString0() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        Object object = "0";

        boolean actual = myLinkedList.remove(object);
        assertTrue(actual);
    }
    @Test
    void testRemoveString1() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        Object object = "1";

        boolean actual = myLinkedList.remove(object);
        assertTrue(actual);
    }
    @Test
    void testRemoveString2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        Object object = "2";

        boolean actual = myLinkedList.remove(object);
        assertTrue(actual);
    }
    @Test
    void testRemoveString3() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        Object object = "3";

        boolean actual = myLinkedList.remove(object);
        assertFalse(actual);
    }
    @Test
    void testRemoveIndex0() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 0;

        String expected = "0";
        String actual = myLinkedList.remove(index);
        assertEquals(expected,actual);
    }
    @Test
    void testRemoveIndex1() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 1;

        String expected = "1";
        String actual = myLinkedList.remove(index);
        assertEquals(expected,actual);
    }
    @Test
    void testRemoveIndex2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 2;

        String expected = "2";
        String actual = myLinkedList.remove(index);
        assertEquals(expected,actual);
    }

    @Test
    void testGetIndex0() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 0;

        String expected = "0";
        String actual = myLinkedList.get(index);
        assertEquals(expected, actual);
    }

    @Test
    void testGetIndex1() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 1;

        String expected = "1";
        String actual = myLinkedList.get(index);
        assertEquals(expected, actual);
    }

    @Test
    void testGetIndex2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        int index = 2;

        String expected = "2";
        String actual = myLinkedList.get(index);
        assertEquals(expected, actual);
    }

    @Test
    void testSize3() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertEquals(myLinkedList.getNumNodes(), myLinkedList.size());
    }

    @Test
    void testSize1() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");

        assertEquals(myLinkedList.getNumNodes(), myLinkedList.size());
    }

    @Test
    void testGetFirst() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertEquals("0", myLinkedList.getFirst());
    }

    @Test
    void testGetLast() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertEquals("2", myLinkedList.getLast());
    }

    @Test
    void testContains0() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertTrue(myLinkedList.contains("0"));
    }

    @Test
    void testContains2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertTrue(myLinkedList.contains("2"));
    }

    @Test
    void testContainsNeg1() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertFalse(myLinkedList.contains("-1"));
    }

    @Test
    void indexOf0() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertEquals(0,myLinkedList.indexOf("0"));
    }

    @Test
    void indexOf2() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertEquals(2,myLinkedList.indexOf("2"));
    }

    @Test
    void indexOf3() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>("0");
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");

        assertEquals(-1,myLinkedList.indexOf("3"));
    }
}