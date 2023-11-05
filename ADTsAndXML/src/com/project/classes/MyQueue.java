/**
 * 
 */
package com.project.classes;

import java.util.EmptyStackException;
import java.util.LinkedList;

import com.project.interfaces.QueueADT;

/**
 * @author Ruthless
 *
 */
public class MyQueue<E> implements QueueADT<E> {
    private LinkedList<E> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(E item) {
        queue.addLast(item);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}