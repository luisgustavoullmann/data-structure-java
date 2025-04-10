package trees.binary_search.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinarySearchTreeSet<K extends Comparable<K>> {
    private int size;
    private Node root;

    public BinarySearchTreeSet() {
        this.size = 0;
        this.root = new Node(null, null);
    }

    public BinarySearchTreeSet(Collection<K> c) {
        this();
        this.addAll(c);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");

        Node nodeToRemove = findKeyLocation(this.root, key);

        if (nodeToRemove.isLeaf()) return false;

        if (!nodeToRemove.left.isLeaf() && !nodeToRemove.right.isLeaf()) {
            Node successor = findMin(nodeToRemove.right);
            nodeToRemove.key = successor.key;
            nodeToRemove = successor;
        }

        Node child = nodeToRemove.left.isLeaf() ? nodeToRemove.right : nodeToRemove.left;
        child.parent = nodeToRemove.parent;

        if (nodeToRemove.parent == null) this.root = child;
        else if (nodeToRemove == nodeToRemove.parent.left) nodeToRemove.parent.left = child;
        else nodeToRemove.parent.right = child;

        this.size--;
        return true;
    }

    private Node findMin(Node node) {
        while (!node.left.isLeaf()) {
            node = node.left;
        }
        return node;
    }

    public void add(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");

        if (this.isEmpty()) {
            this.root = new Node(key, null);
            this.root.left = new Node(null, this.root);
            this.root.right = new Node(null, this.root);
            this.size++;
            return;
        }

        Node node = findKeyLocation(this.root, key);

        if (node.isLeaf()) {
            Node parent = node.parent;
            Node newNode = new Node(key, parent);
            newNode.left = new Node(null, newNode);
            newNode.right = new Node(null, newNode);

            if (node == parent.left) parent.left = newNode;
            else if (node == parent.right) parent.right = newNode;
        }
        this.size++;
    }

    private Node findKeyLocation(Node node, K key) {
        while (!node.isLeaf()) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) return node;
            else if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return node;
    }

    public void addAll(Collection<K> c) {
        for (K item : c) {
            add(item);
        }
    }

    public boolean contains(K key) {
        Node node = findKeyLocation(this.root, key);
        return !node.isLeaf();
    }

    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        collectKeys(this.root, keysList);
        return keysList;
    }

    private void collectKeys(Node node, List<K> keysList) {
        if (!node.isLeaf()) {
            collectKeys(node.left, keysList);
            keysList.add(node.key);
            collectKeys(node.right, keysList);
        }
    }

    public BinarySearchTreeSet<K> union(BinarySearchTreeSet<K> other) {
        BinarySearchTreeSet<K> result = new BinarySearchTreeSet<>();
        for (K key : this.keys()) {
            result.add(key);
        }
        for (K key : other.keys()) {
            result.add(key);
        }
        return result;
    }

    public BinarySearchTreeSet<K> intersection(BinarySearchTreeSet<K> other) {
        BinarySearchTreeSet<K> result = new BinarySearchTreeSet<>();
        for (K key : this.keys()) {
            if (other.contains(key)) {
                result.add(key);
            }
        }
        return result;
    }
    public BinarySearchTreeSet<K> difference(BinarySearchTreeSet<K> other) {
        BinarySearchTreeSet<K> result = new BinarySearchTreeSet<>();
        for (K key : this.keys()) {
            if (!other.contains(key)) {
                result.add(key);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return this.keys().toString();
    }

    public String toStringFormat() {
        StringBuilder sb = new StringBuilder();
        toStringFormat(this.root, 0 ,sb);
        return sb.toString();
    }

    public void toStringFormat(Node node, int depth, StringBuilder sb) {
        if (!node.isLeaf()) {
            toStringFormat(node.right, depth + 1, sb);
            String space = (depth > 0) ? " ".repeat(depth -1) + "--" : "";
            String parent = (depth > 0) ? node.parent.key.toString() : "";
            sb.append(space + "(" + node.key + ")" + parent + "\n");
            toStringFormat(node.left, depth + 1, sb);
        }
    }

    private class Node {
        K key;
        Node left, right, parent;

        Node(K key, Node parent) {
            this.key = key;
            this.parent = parent;
            this.left = this.right = null;
        }

        boolean isLeaf() {
            return key == null;
        }
    }
}
