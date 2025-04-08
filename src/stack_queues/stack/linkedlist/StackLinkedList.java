package stack_queues.stack.linkedlist;

import lists.linked_list.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class StackLinkedList<T> {
    private LinkedList<T> list;

    public StackLinkedList() {
        this.list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void push(T item) {
        this.list.addAtEnd(item);
    }

    public T pop() {
        if (this.isEmpty()) throw new IllegalStateException("Stack is empty");
        return this.list.removeAtPosition(this.list.getSize() -1);
    }

    public T peek() {
        if (this.isEmpty()) throw new IllegalStateException("Stack is empty");
        return this.list.get(this.list.getSize() - 1);
    }

    public int count() {
        return this.list.getSize();
    }

    public void clear() {
        this.list = new LinkedList<>();
    }
}
