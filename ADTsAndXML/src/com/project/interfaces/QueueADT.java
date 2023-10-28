/**
 * 
 */
package com.project.interfaces;

/**
 * @author Ruthless
 *
 */
/**
 * This interface represents a queue data structure.
 *
 * @param <E> the type of elements stored in the queue
 */
public interface QueueADT<E> {

    /**
     * Enqueues an item into the queue.
     * 
     * Enqueue places item at the back of the queue
     *
     * @param item the item to enqueue
     */
    void enqueue(E item);

    /**
     * Dequeues and returns the front item from the queue.
     *
     * @return the front item from the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E dequeue();

    /**
     * Returns the front item from the queue without removing it.
     *
     * @return the front item from the queue
     * @throws EmptyQueueException if the queue is empty
     */
    E peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the queue.
     *
     * @return the size of the queue
     */
    int size();
}
