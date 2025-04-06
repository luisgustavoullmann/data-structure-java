package lists.linked_list;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public void addAtStart(T elem) {
        Node<T> node = new Node<>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.size++;
            return;
        }

        Node<T> auxCurrentHead = this.head;
        this.head = node;
        node.setNext(auxCurrentHead);
        this.size++;
    }

    public void addAtEnd(T elem) {
        Node<T> node = new Node<>(elem);
        if (this.isEmpty()) {
            this.head = node;
            this.size++;
            return;
        }

        Node<T> current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
        this.size++;
    }

    public void addAtPosition(int index, T elem) {
        if (index == 0) {
            this.addAtStart(elem);
            return;
        }

        if (this.get(index) == null) {
            this.addAtEnd(elem);
            return;
        }

        Node<T> node = new Node<T>(elem);
        Node<T> auxBefore = this.getNode(index - 1);
        node.setNext(auxBefore.getNext());
        auxBefore.setNext(node);
        this.size++;
    }

    public T get(int index) {
        Node<T> current = this.getNode(index);
        if (current != null) return current.getValue();
        return null;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index > this.getSize()) return null;

        Node<T> current = this.head;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        if (current != null) return current;
        return null;
    }

    public int indexOf(T elem) {
        Node<T> current = this.head;
        int i = 0;
        while (current != null) {
            if (current.getValue() == elem) return i;
            current = current.getNext();
            i++;
        }
        return -1;
    }

    public boolean contains(T elem) {
        int indexElem = this.indexOf(elem);
        return indexElem != -1;
    }

    public T removeAtPosition(int index) {
        if (this.isEmpty() || this.get(index) == null) return null;

        T item = null;
        Node<T> aux = null;
        if (index == 0) {                         // head
            item = this.head.getValue();
            this.head = this.head.getNext();
        } else if (index == this.getSize() - 1) { // end
            item = this.get(index);
            aux = this.getNode(index - 1);
            aux.setNext(null);
        } else {                                // middle
            aux = this.getNode(index - 1);
            item = aux.getNext().getValue();
            aux.setNext(aux.getNext().getNext());
        }
        this.size--;
        return item;
    }

    public boolean remove(T elem) {
        int index = this.indexOf(elem);
        if (this.isEmpty() || index == -1) return false;
        this.removeAtPosition(index);
        return true;
    }

    public Object[] toArray() {
        Object[] arr = new Object[getSize()];
        Node<T> current = this.head;
        for (int i = 0; i < getSize(); i ++) {
            arr[i] = current.getValue();
            current = current.getNext();
        }
        return arr;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "[]";

        StringBuilder builder = new StringBuilder("[");
        Node<T> current = this.head;
        while (current.getNext() != null) {
            builder.append(current.getValue()).append(",");
            current = current.getNext();
        }
        builder.append(current.getValue()).append("]");
        return builder.toString();
    }
}
