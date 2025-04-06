package lists.doubly_linked_list;

import lists.linked_list.Node;

public class DoublyLinkedList<T> {
    private NodeDoubly<T> head;
    private NodeDoubly<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return this.size;
    }

    public void addAtStart(T elem) {
        NodeDoubly<T> node = new NodeDoubly<>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }
        this.size++;
    }

    public void addAtEnd(T elem) {
        NodeDoubly<T> node = new NodeDoubly<>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.setPrev(this.tail);
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    public T get(int index) {
        NodeDoubly<T> current = getNode(index);
        if (current != null) return current.getValue();
        throw new IndexOutOfBoundsException("Index: " + index + " - size: " + size);
    }

    private NodeDoubly<T> getNode(int index) {
        if (index < 0 || index > this.getSize()) throw new IllegalArgumentException("Index out of bound");

        NodeDoubly<T> current = this.head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            current = current.getNext();
        }
        return current;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    public int indexOf(T elem) {
        NodeDoubly<T> current = this.head;
        int index = 0;
        while (current != null) {
            if (current.getValue().equals(elem)) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public T removeHead() {
        if (this.isEmpty()) throw new IllegalArgumentException("List is empty");

        NodeDoubly<T> node = this.head;
        this.head = this.head.getNext();

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.setPrev(null);
        }
        this.size--;
        return node.getValue();
    }

    public T removeTail() {
        if (this.isEmpty()) throw new IllegalArgumentException("List is empty");

        NodeDoubly<T> node = this.tail;
        this.tail = this.tail.getPrev();

        if (this.tail == null) this.head = null;
        else this.tail.setNext(null);

        this.size--;
        return node.getValue();
    }

    public T removeAtPosition(int index) {
        if (this.isEmpty() || index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid index or empty list");
        }

        if (index == 0) return removeHead();
        if (index == this.size -1) return removeTail();

        NodeDoubly<T> current = this.getNode(index);
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        this.size--;
        return current.getValue();
    }

    public boolean remove(T elem) {
        int index = indexOf(elem);
        if (this.isEmpty() || index == -1) return false;
        removeAtPosition(index);
        return true;
    }

    public void reverse() {
        NodeDoubly<T> temp = null;
        NodeDoubly<T> current = this.head;
        this.tail = this.head;
        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev();
        }
        if (temp != null) this.head = temp.getPrev();
    }

    public Object[] toArray() {
        Object[] result = new Object[this.size];
        NodeDoubly<T> current = this.head;
        int index = 0;
        while (current != null) {
            result[index++] = current.getValue();
            current = current.getNext();
        }
        return result;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";

        StringBuilder builder = new StringBuilder("[");
        NodeDoubly<T> current = this.head;
        while (current.getNext() != null) {
            builder.append(current.getValue()).append(",");
            current = current.getNext();
        }
        builder.append(current.getValue()).append("]");
        return builder.toString();
    }
}
