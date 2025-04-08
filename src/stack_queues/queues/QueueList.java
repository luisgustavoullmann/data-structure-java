package stack_queues.queues;

import java.util.ArrayList;
import java.util.List;

public class QueueList<T> {
    private List<T> list;

    public QueueList() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void add(T item) {
        this.list.add(item);
    }

    public T remove() {
        if (this.isEmpty()) throw new IllegalStateException("Queue is empty");
        return this.list.removeFirst();
    }

    public T peek() {
        if (this.isEmpty()) throw new IllegalStateException("Queue is empty");
        return this.list.getFirst();
    }

    public int count() {
        return this.list.size();
    }

    @Override
    public String toString() {
        return "QueueList" + list;
    }
}
