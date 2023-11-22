/**
 * 
 */
package com.project.classes;

import java.util.Iterator;

import com.project.interfaces.ListADT;

/**
 * @author Ruthless
 * @param <E>
 *
 */
public class MyArrayList<E> implements ListADT<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 42L;
	private Object[] array;
	private int size;
	
	public MyArrayList() {
		this.array = new Object[20];
		this.size = 0;
	}
	
    // Helper method to find the index of an element
    private int indexOf(Object toFind) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }
    
    private void arrayCapacity() {
        if (size == array.length) {
            // Double the size of the array when reaching its capacity
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
    

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		
	}

	@Override
	public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		arrayCapacity();
		
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		
		array[index] = toAdd;
		size++;
		return true;
	}

	@Override
	public boolean add(Object toAdd) throws NullPointerException {
		arrayCapacity();
		

	    array[size++] = toAdd;
	    return true;
		//add(size, toAdd);
		//return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	    Iterator<? extends E> iterator = toAdd.iterator();
	    while (iterator.hasNext()) {
	        add(iterator.next());
	    }
	    return true;
	}

	@SuppressWarnings("unchecked")
	@Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) array[index];
    }

	@SuppressWarnings("unchecked")
	@Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        E removedElement = (E) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        return removedElement;
    }

	@Override
    public E remove(Object toRemove) throws NullPointerException {
        int index = indexOf(toRemove);

        if (index != -1) {
            return remove(index);
        }

        return null;
    }

	@SuppressWarnings("unchecked")
	@Override
    public E set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        E oldElement = (E) array[index];
        array[index] = toChange;
        return oldElement;
    }

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
    public boolean contains(Object toFind) throws NullPointerException {
        // Check if the element is present in the array
        for (int i = 0; i < size; i++) {
            if (array[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

	@SuppressWarnings("unchecked")
	@Override
    public E[] toArray(Object[] toHold) throws NullPointerException {
        if (toHold.length < size) {
            throw new IllegalArgumentException("Array is too small");
        }

        // Copy elements to the provided array
        System.arraycopy(array, 0, toHold, 0, size);
        return (E[]) toHold;
    }

	@Override
	public Object[] toArray() {
		return toArray(new Object[size]);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
