/**
 * 
 */
package unitTests;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.project.classes.MyQueue;

/**
 * @author Ruthless
 *
 */
public class MyQueueTests<E> {
	private MyQueue<Integer> myQueue;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myQueue = new MyQueue<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		myQueue = null;
	}

    @Test
    public void testEnqueue() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue(1);
        assertFalse(myQueue.isEmpty());
        assertEquals(1, myQueue.size());
        assertEquals(Integer.valueOf(1), myQueue.peek());
    }

    @Test
    public void testDequeue() {
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        assertEquals(2, myQueue.size());
        assertEquals(Integer.valueOf(1), myQueue.dequeue());
        assertEquals(1, myQueue.size());
        assertEquals(Integer.valueOf(2), myQueue.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testDequeueEmptyQueue() {
        myQueue.dequeue();
    }

    @Test
    public void testPeek() {
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        assertEquals(Integer.valueOf(1), myQueue.peek());
        assertEquals(2, myQueue.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyQueue() {
        myQueue.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myQueue.isEmpty());
        myQueue.enqueue(1);
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, myQueue.size());
        myQueue.enqueue(1);
        assertEquals(1, myQueue.size());
        myQueue.enqueue(2);
        assertEquals(2, myQueue.size());
    }
}
