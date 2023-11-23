/**
 * 
 */
package unitTests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.classes.MyDLL;




/**
 * @author Ruthless
 *
 */
public class MyDLLTests<E> {
	private MyDLL<Integer> myList;

	@Before
	public void setUp() throws Exception {
		myList = new MyDLL<>();
	}

	@After
	public void tearDown() throws Exception {
		myList = null;
	}
	

	@Test
    public void testSize() {
        assertEquals(0, myList.size());
        myList.add(1);
        assertEquals(1, myList.size());
        myList.add(2);
        assertEquals(2, myList.size());
        myList.remove(0);
        assertEquals(1, myList.size());
    }

    @Test
    public void testClear() {
        myList.add(1);
        myList.add(2);
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testAddAtIndex() {
        myList.add(1);
        myList.add(2);
        myList.add(1, 3);
        assertEquals(3, (int) myList.get(1));
        assertEquals(2, (int) myList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexWithInvalidIndex() {
        myList.add(1, 4);
    }

    @Test
    public void testAdd() {
        assertTrue(myList.add(1));
        assertTrue(myList.add(2));
        assertEquals(1, (int) myList.get(0));
        assertEquals(2, (int) myList.get(1));
    }

    @Test
    public void testAddAll() {
        MyDLL<Integer> otherList = new MyDLL<>();
        otherList.add(3);
        otherList.add(4);
        myList.add(1);
        myList.add(2);
        assertTrue(myList.addAll(otherList));
        assertEquals(1, (int) myList.get(0));
        assertEquals(2, (int) myList.get(1));
        assertEquals(3, (int) myList.get(2));
        assertEquals(4, (int) myList.get(3));
    }

    @Test
    public void testGet() {
        myList.add(1);
        myList.add(2);
        assertEquals(1, (int) myList.get(0));
        assertEquals(2, (int) myList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithInvalidIndex() {
        myList.get(0);
    }

    @Test
    public void testRemoveAtIndex() {
        myList.add(1);
        myList.add(2);
        assertEquals(1, (int) myList.remove(0));
        assertEquals(2, (int) myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexWithInvalidIndex() {
        myList.remove(0);
    }

    @Test
    public void testRemoveByValue() {
        myList.add(1);
        myList.add(2);
        assertEquals(2, (int) myList.remove(1));
        assertEquals(1, (int) myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
    public void testSet() {
        myList.add(1);
        myList.add(2);
        assertEquals(1, (int) myList.set(0, 3));
        assertEquals(3, (int) myList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithInvalidIndex() {
        myList.set(0, 4);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myList.isEmpty());
        myList.add(1);
        assertFalse(myList.isEmpty());
    }

    @Test
    public void testContains() {
        myList.add(1);
        myList.add(2);
        assertTrue(myList.contains(1));
        assertFalse(myList.contains(3));
    }

    @Test
    public void testToArray() {
        myList.add(1);
        myList.add(2);
        Integer[] array = new Integer[2];
        myList.toArray(array);
        assertArrayEquals(new Integer[]{1, 2}, array);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayWithNullArray() {
        myList.toArray(null);
    }

    @Test
    public void testIterator() {
        myList.add(1);
        myList.add(2);
        StringBuilder result = new StringBuilder();

        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }

        assertEquals("12", result.toString());
    }
}