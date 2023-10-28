/**
 * 
 */
package com.project.interfaces;

/**
 * @author Ruthless
 *
 */

/**
 * This interface represents a stack data structure.
 *
 * @param <E> the type of elements stored in the stack
 */
public interface StackADT<E> {

	/**
     * Pushes an item onto the stack.
     *
     * @param item the item to push onto the stack
     */
    void push(E item);

    /**
     * Removes and returns the top item from the stack.
     *
     * @return the top item from the stack
     * @throws EmptyStackException if the stack is empty
     */
    E pop();

    /**
     * Returns the top item from the stack without removing it.
     *
     * @return the top item from the stack
     * @throws EmptyStackException if the stack is empty
     */
    E peek();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the stack.
     *
     * @return the size of the stack
     */
    int size();
}
