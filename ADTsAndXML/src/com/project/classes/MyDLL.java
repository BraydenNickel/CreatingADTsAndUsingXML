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
public class MyDLL<E> implements ListADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 42L;
	
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IllegalStateException("Node is unexpectedly null");
            }
            current = current.next;
        }
        return current;
    }

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<E> newNode = new Node<>(toAdd);

        if (index == 0) {
            // Adding at the beginning
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;

            if (tail == null) {
                // If the list was empty, update the tail
                tail = newNode;
            }
        } else if (index == size) {
            // Adding at the end
            newNode.prev = tail;
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;

            if (head == null) {
                // If the list was empty, update the head
                head = newNode;
            }
        } else {
            Node<E> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }

        size++;
        return true;
    }

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		return add(size, toAdd);
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	    if (toAdd == null) {
	        throw new NullPointerException("Cannot add null object");
	    }

	    boolean modified = false;
	    Iterator<? extends E> iterator = toAdd.iterator();
	    while (iterator.hasNext()) {
	        if (add(iterator.next())) {
	            modified = true;
	        }
	    }

	    return modified;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index <0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return getNode(index).data;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invaild index");
		}
		
		Node<E> removedNode = getNode(index);
		
		if (index == 0) {
			head = removedNode.next;
			if(head != null) {
				head.prev = null;
			}
		}
		else if (index == size - 1) {
			tail = removedNode.prev;
			if (tail != null) {
				tail.next = null;
			}
		}
		else {
			removedNode.prev.next = removedNode.next;
			removedNode.next.prev = removedNode.prev;
		}
		size--;
		return removedNode.data;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
	    if (toRemove == null) {
	        throw new NullPointerException("Cannot remove null element");
	    }

	    Node<E> current = head;
	    while (current != null) {
	        if (toRemove.equals(current.data)) {
	            if (current.prev != null) {
	                current.prev.next = current.next;
	            } else {
	                head = current.next;
	            }

	            if (current.next != null) {
	                current.next.prev = current.prev;
	            } else {
	            	tail = current.prev;
	            }

	            size--;
	            return current.data; 
	        }
	        current = current.next;
	    }

	    return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<E> node = getNode(index);
        E oldValue = node.data;
        node.data = toChange;

        return oldValue;
    }

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
	    if (toFind == null) {
	        throw new NullPointerException("Cannot search for null element");
	    }

	    Node<E> current = head;
	    while (current != null) {
	        if (toFind.equals(current.data)) {
	            return true;
	        }
	        current = current.next;
	    }

	    return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E[] toArray(E[] toHold) throws NullPointerException {
	    if (toHold == null) {
	        throw new NullPointerException("Array to hold elements cannot be null");
	    }

	    if (toHold.length < size) {
	        toHold = (E[]) java.lang.reflect.Array.newInstance(
	                toHold.getClass().getComponentType(), size);
	    }

	    int index = 0;
	    Node<E> current = head;
	    while (current != null) {
	        toHold[index++] = current.data;
	        current = current.next;
	    }

	    if (toHold.length > size) {
	        toHold[size] = null; // Set the element after the last one to null
	    }

	    return toHold;
	}

	@Override
	public Object[] toArray() {
	    Object[] array = new Object[size];
	    int index = 0;
	    Node<E> current = head;
	    while (current != null) {
	        array[index++] = current.data;
	        current = current.next;
	    }
	    return array;
	}

	@Override
	public Iterator<E> iterator() {
	    return new Iterator<E>() {
	        private Node<E> current = head;

	        @Override
	        public boolean hasNext() {
	            return current != null;
	        }

	        @Override
	        public E next() {
	            if (!hasNext()) {
	                throw new java.util.NoSuchElementException();
	            }
	            E data = current.data;
	            current = current.next;
	            return data;
	        }
	    };
	}
}
