import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    // STATIC NESTED: a node doesn't need the outer list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) { this.data = data; }
    }

    private Node<T> head;   // null when the list is empty
    private int size;

    // Add to the front (O(1))
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        size++;
    }

    // Add to the end (O(n) — walks the whole list)
    public void addLast(T item) {
        Node<T> node = new Node<>(item);
        if (head == null) {
            head = node;
        } else {
            Node<T> curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
        }
        size++;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    // Required by Iterable<T> — returns a fresh iterator each call
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    // INNER CLASS: holds a hidden reference to this LinkedList,
    // so it can read 'head' directly.
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            T value = current.data;
            current = current.next;
            return value;
        }
    }
}