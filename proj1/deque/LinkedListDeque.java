package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, java.lang.Iterable<T> {
    private int size;
    private Node sentinal = new Node(null, null, null);

    private class Node {
        T value;
        Node nextNode;
        Node lastNode;

        Node(T value, Node next, Node last) {
            this.value = value;
            nextNode = next;
            lastNode = last;
        }
    }
    public LinkedListDeque() {
        size = 0;
        sentinal.nextNode = sentinal;
        sentinal.lastNode = sentinal;
    }

    /**
     * Add an element at the start of the list.
     * @param item
     */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinal.nextNode, sentinal);
        sentinal.nextNode.lastNode = newNode;
        sentinal.nextNode = newNode;
        size++;
    }

    /**
     * Add an element at the end of the list.
     * @param item
     */
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinal, sentinal.lastNode);
        sentinal.lastNode.nextNode = newNode;
        sentinal.lastNode = newNode;
        size++;
    }

    /**
     * Function to return the size of current list.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     *  Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
        if (size == 0) {
            System.out.println("empty");
            return;
        }
        Node current = sentinal.nextNode;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(current.value + " ");
            current = current.nextNode;
        }
        System.out.println(current.value);
    }

    /**
     * Removes and returns the item at the front of the deque.
     * @return the first item. If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T returnFirst = sentinal.nextNode.value;
        sentinal.nextNode.nextNode.lastNode = sentinal;
        sentinal.nextNode = sentinal.nextNode.nextNode;
        size = size - 1;
        return (returnFirst);
    }

    /**
     * Removes and returns the item at the end of the deque.
     * @return the last item. If no such item exists, return null.
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return (null);
        }
        T returnLast = sentinal.lastNode.value;
        sentinal.lastNode.lastNode.nextNode = sentinal;
        sentinal.lastNode = sentinal.lastNode.lastNode;
        size = size - 1;
        return (returnLast);
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * Must not alter the deque!
     * @param index
     * @return the index-th item. If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node current = sentinal.nextNode;
        T returnValue = current.value;
        for (int i = 0; i <= index; i++) {
            returnValue = current.value;
            current = current.nextNode;
        }
        return (returnValue);
    }

    /**
     * Gets the item at the given index using recursion method.
     * @param index
     * @return the index-th item. If no such item exists, returns null.
     */
    public T getRecursive(int index) {
        Node current = sentinal.nextNode;
        return (recursion(index, current));
    }
    //  @recursion How to construct recursion with a predefined parameter?
    //  create a new one with different parameters
    private T recursion(int num, Node current) {
        if (num == 0) {
            return  current.value;
        }
        return recursion(num - 1, current.nextNode);
    }
    @Override
    public Iterator<T> iterator() {
        return new NewIterator();
    }

    private class NewIterator<T> implements Iterator {
        private  int startPosition = 0;
        Node current = sentinal.nextNode;
        T returnValue;

        @Override
       public boolean hasNext() {
        //   compare if the next position has a value( based on size)
            return  (startPosition < size());
        }
        @Override
       public T next() {
            returnValue = (T) current.value;
            current = current.nextNode;
            startPosition++;
            return returnValue;
        }
    }

    @Override
    public boolean equals(Object o) {
    // test if the class is the same
        if (o instanceof Deque) {
            if (this.size() != ((Deque<?>) o).size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if (!this.get(i).equals(((Deque) o).get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }



}


