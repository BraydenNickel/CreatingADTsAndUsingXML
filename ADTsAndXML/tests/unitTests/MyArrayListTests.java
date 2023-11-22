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

}
