package trees.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenericTree<T> {
    private Node<T> root;
    private int size;

    public GenericTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public List<T> elements() {
        List<T> elements = new ArrayList<>();
        collectElements(elements, this.root);
        return elements;
    }

    private void collectElements(List<T> list, Node<T> node) {
        list.add(node.element());
        for (Node<T> child : node.getChildren()) {
            collectElements(list, child);
        }
    }

    public List<Position<T>> positions() {
        List<Position<T>> positions = new ArrayList<>();
        collectPositions(positions, root);
        return positions;
    }

    private void collectPositions(List<Position<T>> list, Node<T> node) {
        list.add(node);
        for (Node<T> child : node.getChildren()) {
            collectPositions(list, child);
        }
    }

    public void replace(Position<T> position, T element) {
        Node<T> node = validate(position);
        node.setElement(element);
    }

    public Position<T> root() {
        return root;
    }


    public Position<T> parent(Position<T> position) {
        Node<T> node = validate(position);
        return node.getParent();
    }

    public List<Position<T>> children(Position<T> position) {
        Node<T> node = validate(position);
        return new ArrayList<>(node.getChildren());
    }

    public boolean isExternal(Position<T> position) {
        Node<T> node = validate(position);
        return node.getChildren().isEmpty();
    }

    public boolean isRoot(Position<T> position) {
        Node<T> node = validate(position);
        return node == this.root;
    }

    private Node<T> validate(Position<T> position) {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("Invalid position type");
        }
        Node<T> node = (Node<T>) position;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("Position is no longer in the tree");
        }
        return node;
    }

    public Position<T> add(T element, Position<T> parent) {
        if (!isEmpty() && parent == null) {
            throw new IllegalArgumentException("Parent position can't be null");
        }

        Node<T> parentNode = parent == null ? null : validate(parent);
        Node<T> newNode = new Node<>(element, parentNode);
        if (parentNode == null) {
            this.root = newNode;
        }
        else {
            parentNode.addChild(newNode);
        }
        this.size++;
        return newNode;
    }

    public void remove(Position<T> position) {
        Node<T> node = validate(position);
        if (node == this.root) this.root = null;
        else {
            Node<T> parent = node.getParent();
            if (parent != null) parent.removeChild(node);
        }
        this.size -= subTreeSize(node);
        markAsRemoved(node);
    }

    private int subTreeSize(Node<T> node) {
        int subTreeCount = 1;
        for (Node<T> child : node.getChildren()) {
            subTreeCount += subTreeSize(child);
        }
        return subTreeCount;
    }


    private void markAsRemoved(Node<T> node) {
        node.setParent(node);
        for (Node<T> child : node.getChildren()) {
            markAsRemoved(child);
        }
    }

    public Position<T> find(T element) {
        return findRecursive(this.root, element);
    }

    private Position<T> findRecursive(Node<T> node, T target) {
        if (node == null) return null;
        if (node.element().equals(target)) return node;

        for (Node<T> child : node.getChildren()) {
            Position<T> found = findRecursive(child, target);
            if (found != null) return found;
        }
        return null;
    }

    public static <T> void print(GenericTree<T> tree) {
        printRecursive(tree.root(), tree, 0);
    }

    public static <T> void printRecursive(Position<T> position, GenericTree<T> tree, int depth) {
        String spaces = "    ".repeat(depth);
        System.out.println(spaces + position.element());
        for (Position<T> child : tree.children(position)) {
            printRecursive(child, tree, depth + 1);
        }
    }

    public static <T> void printBfs(GenericTree<T> tree) {
        if (tree.isEmpty()) {
            return;
        }
        Queue<Position<T>> queue = new LinkedList<>();
        queue.add(tree.root());
        while (!queue.isEmpty()) {
            Position<T> position = queue.poll();
            System.out.println(position.element());
            queue.addAll(tree.children(position));
        }
    }
}
