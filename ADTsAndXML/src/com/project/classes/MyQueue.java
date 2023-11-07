/**
 * 
 */
package com.project.classes;

import java.util.EmptyStackException;
import com.project.interfaces.QueueADT;

/**
 * @author Ruthless
 *
 */
public class MyQueue<E> implements QueueADT<E> {
    private MyArrayList<E> queue;

    public MyQueue() {
        queue = new MyArrayList<>();
    }

    @Override
    public void enqueue(E item) {
        queue.add(item);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.get(0);
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