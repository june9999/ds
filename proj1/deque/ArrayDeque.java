package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, java.lang.Iterable<T> {
    private int size;
    private T[] arrayNode;

    public ArrayDeque() {
        size = 0;
        arrayNode = (T[]) new Object[8];
    }

    @Override
    public void addFirst(T item) {
        if (arrayNode.length == size) {
            T[] newNode = (T[]) new Object[size * 2];
            System.arraycopy(arrayNode, 0, newNode, 0, arrayNode.length);
            arrayNode = newNode;
        }
        T[] saveNode = arrayNode.clone();
        arrayNode[0] = item;
        for (int i = 0; i < size; i++) {
            arrayNode[i + 1] = saveNode[i];
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (arrayNode.length == size) {
            T[] newNode = (T[]) new Object[size * 2];
            System.arraycopy(arrayNode, 0, newNode, 0, arrayNode.length);
            arrayNode = newNode;
        }
        arrayNode[size] = item;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size - 1; i++) {
            System.out.print(arrayNode[i] + " ");
        }
        System.out.println(arrayNode[size - 1]);
    }

    @Override
    public T removeFirst() {
        while (arrayNode.length > 16 && size < 0.25 * arrayNode.length) {
            System.out.println(arrayNode.length / 4);
            T[] newNode = (T[]) new Object[arrayNode.length / 4];
            System.arraycopy(arrayNode, 0, newNode, 0, newNode.length);
            arrayNode = newNode;
        }
        if (size == 0) {
            return null;
        }
        T savedElement = arrayNode[0];
        T[] saveNode = arrayNode.clone();
        for (int i = 1; i < size; i++) {
            arrayNode[i - 1] = saveNode[i];
        }
        size--;
        return savedElement;
    }

    @Override
    public T removeLast() {
        while (arrayNode.length > 16 && size < 0.25 * arrayNode.length) {
            System.out.println(arrayNode.length / 4);
            T[] newNode = (T[]) new Object[arrayNode.length / 4];
            System.arraycopy(arrayNode, 0, newNode, 0, newNode.length);
            arrayNode = newNode;
        }
        if (size == 0) {
            return null;
        }
        T savedElement = arrayNode[size - 1];
        arrayNode[size - 1] = null;
        size--;
        return (savedElement);
    }

    @Override
    public T get(int index) {
        return (arrayNode[index]);
    }


    @Override
    public Iterator<T> iterator() {
        return new NewIterator();
    }

    private class NewIterator implements java.util.Iterator<T> {
        int currentPosition = 0;
        T value;

        @Override
        public boolean hasNext() {
            if (arrayNode[currentPosition + 1].equals(null)) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            value = arrayNode[currentPosition];
            currentPosition++;
            return (value);
        }
    }

    @Override
    public boolean equals(Object o) {
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
