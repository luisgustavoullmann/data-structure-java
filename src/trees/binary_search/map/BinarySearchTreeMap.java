package trees.binary_search.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BinarySearchTreeMap <K extends Comparable<K>, V> {
    private int size;
    private Node root;

    public BinarySearchTreeMap() {
        this.size = 0;
        this.root = new Node(null, null, null);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public V get(K key) {
        Node node = findKeyLocation(this.root, key);
        return node.isLeaf() ? null : node.value;

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

    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");

        Node nodToRemove = findKeyLocation(this.root, key);
        if (nodToRemove.isLeaf()) return null;

        V removedValue = nodToRemove.value;

        if (!nodToRemove.left.isLeaf() && !nodToRemove.right.isLeaf()) {
            Node successor = findMin(nodToRemove.right);
            nodToRemove.key = successor.key;
            nodToRemove.value = successor.value;
            nodToRemove = successor;
        }

        Node child = nodToRemove.left.isLeaf() ? nodToRemove.right : nodToRemove.left;
        child.parent = nodToRemove.parent;

        if (nodToRemove.parent == null) this.root = child;
        else if (nodToRemove == nodToRemove.parent.left) nodToRemove.parent.left = child;
        else nodToRemove.parent.right = child;

        this.size--;
        return removedValue;
    }

    public void put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");

        if (isEmpty()) {
            this.root = new Node(key, value, null);
            this.root.left = new Node(null, null, this.root);
            this.root.right = new Node(null, null, this.root);
            this.size++;
            return;
        }

        Node node = findKeyLocation(this.root, key);

        if (node.isLeaf()) {
            Node parent = node.parent;
            Node newNode = new Node(key, value, parent);
            newNode.left = new Node(null, null, newNode);
            newNode.right = new Node(null, null, newNode);

            if (node == parent.left) {
                parent.left = newNode;
            } else if (node == parent.right) {
                parent.right = newNode;
            }
            this.size++;
        } else node.value = value; // Update value if key already exists
    }

    public boolean containsKey(K key) {
        Node node = findKeyLocation(this.root, key);
        return !node.isLeaf();
    }

    public List<V> values() {
        List<V> valuesList = new ArrayList<>();
        collectValues(this.root, valuesList);
        return valuesList;
    }

    private void collectValues(Node node, List<V> valuesList) {
        if (!node.isLeaf()) {
            collectValues(node.left, valuesList);
            valuesList.add(node.value);
            collectValues(node.right, valuesList);
        }
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

    private Node findMin(Node node) {
        while (!node.left.isLeaf()) {
            node = node.left;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        toStringHelper(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private void toStringHelper(Node node, StringBuilder sb) {
        if (!node.isLeaf()) {
            toStringHelper(node.right, sb);
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append("\"").append(node.key).append("\": \"").append(node.value).append("\"");
            toStringHelper(node.left, sb);
        }
    }

    private class Node {
        K key;
        V value;
        Node left, right, parent;

        Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
            this.parent = parent;
        }

        // Leaf
        boolean isLeaf() {
            return key == null;
        }
    }
}
