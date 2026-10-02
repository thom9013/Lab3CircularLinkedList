import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CircularLinkedListTest2 {

    @Test
    public void newListShouldBeEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        assertFalse(list.find(10));
        assertFalse(list.remove(10));
    }

    @Test
    public void addItemAndFindShouldWork() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);

        assertTrue(list.find(10));
        assertTrue(list.find(20));
        assertTrue(list.find(30));
        assertFalse(list.find(40));
    }

    @Test
    public void addItemShouldKeepOrder() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);

        assertEquals("10 20 30", captureShowList(list));
    }

    @Test
    public void showReverseListShouldPrintInReverseOrder() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);

        assertEquals("30 20 10", captureShowReverseList(list));
    }

    @Test
    public void removeShouldRemoveFirstOccurrence() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(20);
        list.addItem(30);

        assertTrue(list.remove(20));

        assertEquals("10 20 30", captureShowList(list));
    }

    @Test
    public void removeFirstItemShouldWork() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);

        assertTrue(list.remove(10));

        assertEquals("20 30", captureShowList(list));
    }

    @Test
    public void removeLastItemShouldWork() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);

        assertTrue(list.remove(30));

        assertEquals("10 20", captureShowList(list));
    }

    @Test
    public void removeOnlyItemShouldLeaveListEmpty() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);

        assertTrue(list.remove(10));

        assertFalse(list.find(10));
        assertEquals("", captureShowList(list));
    }

    @Test
    public void removeMissingItemShouldNotChangeList() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);

        assertFalse(list.remove(40));

        assertEquals("10 20 30", captureShowList(list));
    }

    @Test
    public void duplicatesShouldBeSupported() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        list.addItem(5);
        list.addItem(5);
        list.addItem(5);

        assertTrue(list.find(5));

        assertTrue(list.remove(5));
        assertEquals("5 5", captureShowList(list));

        assertTrue(list.remove(5));
        assertEquals("5", captureShowList(list));

        assertTrue(list.remove(5));
        assertEquals("", captureShowList(list));

        assertFalse(list.find(5));
    }

    private String captureShowList(CircularLinkedList<?> list) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try {
            list.showList();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString().trim();
    }

    private String captureShowReverseList(CircularLinkedList<?> list) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try {
            list.showReverseList();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString().trim();
    }


}