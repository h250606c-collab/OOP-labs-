import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {

    private final List<T> items = new ArrayList<>();

    public void push(T item) {
        items.add(item);                    // always add to the end
    }

    public T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        return items.remove(items.size() - 1);   // remove the last element
    }

    public T peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot peek into an empty stack");
        }
        return items.get(items.size() - 1);      // get (but don't remove) last
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();            // bottom .. top
    }
}