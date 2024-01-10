package deque;

public interface Deque<T> {

    /**
     * Add an element at the beginning of the Deque.
     * @param item
     */
    void addFirst(T item);

    /**
     * Add an element at the end of the Deque.
     * @param item
     */
    void addLast(T item);
    default  boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
