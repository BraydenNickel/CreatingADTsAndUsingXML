/**
 * 
 */
package unitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.classes.MyArrayList;

/**
 * @author Ruthless
 *
 */
public class MyArrayListTests<E> {

	/**
	 * @throws java.lang.Exception
	 */
	private MyArrayList<E> myArrayList;
	@Before
	public void setUp() throws Exception {
		myArrayList = new MyArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
		myArrayList = null;
	}

	@Test
	public void testAddAndGet() {
        myArrayList.add(1);
        myArrayList.add(2);

        assertEquals(2, myArrayList.size());
        assertEquals(Integer.valueOf(1), myArrayList.get(0));
        assertEquals(Integer.valueOf(2), myArrayList.get(1));
    }
	
    @Test
    public void testRemove() {
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        assertEquals(Integer.valueOf(2), myArrayList.remove(1));
        assertEquals(2, myArrayList.size());
        assertEquals(Integer.valueOf(1), myArrayList.get(0));
        assertEquals(Integer.valueOf(3), myArrayList.get(1));
    }
    
    @Test
    public void testRemoveByObject() {
        // Add elements to the list
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        // Remove an element by object
        Integer elementToRemove = 2;
        Integer removedElement = (Integer) myArrayList.remove(elementToRemove);

        // Check the result
        assertEquals(2, myArrayList.size());
        assertEquals(Integer.valueOf(1), myArrayList.get(0));
        assertEquals(Integer.valueOf(3), myArrayList.get(1));
        assertEquals(Integer.valueOf(2), removedElement);
    }

    @Test
    public void testRemoveNonExistentObject() {
        // Attempt to remove a non-existent element
        Integer nonExistentElement = 4;
        assertNull(myArrayList.remove(nonExistentElement));
    }


    @Test
    public void testSet() {
        myArrayList.add(1);
        myArrayList.add(2);

        assertEquals(Integer.valueOf(2), myArrayList.set(1, 3));
        assertEquals(2, myArrayList.size());
        assertEquals(Integer.valueOf(1), myArrayList.get(0));
        assertEquals(Integer.valueOf(3), myArrayList.get(1));
    }

    @Test
    public void testContains() {
        myArrayList.add(1);
        myArrayList.add(2);

        assertTrue(myArrayList.contains(1));
        assertFalse(myArrayList.contains(3));
    }

    @Test
    public void testToArray() {
        myArrayList.add(1);
        myArrayList.add(2);

        Integer[] array = new Integer[2];
        myArrayList.toArray(array);

        assertArrayEquals(new Integer[]{1, 2}, array);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myArrayList.isEmpty());

        myArrayList.add(1);
        assertFalse(myArrayList.isEmpty());
    }

}
