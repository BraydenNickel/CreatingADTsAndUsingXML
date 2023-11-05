/**
 * 
 */
package com.project.classes;

import java.util.EmptyStackException;
import java.util.LinkedList;
import com.project.interfaces.StackADT;

/**
 * @author Ruthless
 * @param <E>
 *
 */
public class MyStack<E> implements StackADT<E> {
    private LinkedList<E> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    @Override
    public void push(E item) {
        stack.push(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
