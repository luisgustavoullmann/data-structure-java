package stack_queues.stack.array;

public class StackArray<T> {
    private int size;
    private T[] arr;
    private int top;

    public StackArray() {
        this(100);
    }

    @SuppressWarnings("unchecked")
    public StackArray(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }

    public void push(T item) {
        if (this.isFull()) throw new RuntimeException("Stack is full");
        this.arr[++this.top] = item;
    }

    public T pop() {
        if (this.isEmpty()) throw new RuntimeException("Stack is empty");
        return this.arr[this.top--];
    }

    public T peek() {
        if (this.isEmpty()) throw new RuntimeException("Stack is empty");
        return this.arr[this.top];
    }

    public int count() {
        return this.top + 1;
    }

    public void clear() {
        this.top = -1;
    }
}
