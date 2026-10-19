import java.util.ArrayList;
import java.util.List;

public class Stack<T> {                           // generic (Lab 8 preview)

    private final List<T> items = new ArrayList<>();   // HAS-A list, hidden

    public void push(T item) {
        items.add(item);                          // always at the end
    }

    public T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);    // always from the end
    }

    public T peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
