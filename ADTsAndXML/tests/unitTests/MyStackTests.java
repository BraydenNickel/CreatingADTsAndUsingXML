/**
 * 
 */
package unitTests;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.classes.MyStack;

/**
 * @author Ruthless
 *
 */
public class MyStackTests<E> {
	private MyStack<Integer> myStack;
	

	@Before
	public void setUp() throws Exception {
		myStack = new MyStack<>();
	}

	@After
	public void tearDown() throws Exception {
		myStack = null;
	}

	@Test
    public void testPush() {
        assertTrue(myStack.isEmpty());
        myStack.push(1);
        assertFalse(myStack.isEmpty());
        assertEquals(1, myStack.size());
        assertEquals(Integer.valueOf(1), myStack.peek());
    }

    @Test
    public void testPop() {
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.size());
        assertEquals(Integer.valueOf(2), myStack.pop());
        assertEquals(1, myStack.size());
        assertEquals(Integer.valueOf(1), myStack.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() {
        myStack.pop();
    }

    @Test
    public void testPeek() {
        myStack.push(1);
        myStack.push(2);
        assertEquals(Integer.valueOf(2), myStack.peek());
        assertEquals(2, myStack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() {
        myStack.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myStack.isEmpty());
        myStack.push(1);
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, myStack.size());
        myStack.push(1);
        assertEquals(1, myStack.size());
        myStack.push(2);
        assertEquals(2, myStack.size());
    }
}
