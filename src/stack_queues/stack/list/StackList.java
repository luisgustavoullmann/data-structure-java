package stack_queues.stack.list;

import java.util.ArrayList;
import java.util.List;

public class StackList<T> {
    private List<T> list;

    public StackList() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void push(T item) {
        this.list.add(item);
    }

    public T pop() {
        if (this.isEmpty()) throw new IllegalStateException("Stack is empty");
        return this.list.removeLast();
    }

    public T peek() {
        if (this.isEmpty()) throw new IllegalStateException("Stack is empty");
        return this.list.getLast();
    }

    public int count() {
        return this.list.size();
    }

    public void clear() {
        this.list = new ArrayList<>();
    }
}
