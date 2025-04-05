package lists.linked_list;

import lists.Node;

import java.util.ArrayList;

public class MainLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Is empty: " + linkedList.isEmpty());

        linkedList.addAtEnd(1);
        linkedList.addAtEnd(2);
        linkedList.addAtEnd(3);
        linkedList.addAtEnd(4);

        System.out.println(linkedList.getHead().getValue());
        System.out.println(linkedList.getHead().getNext().getValue());
        System.out.println(linkedList.getHead().getNext().getNext().getValue());

        System.out.println();
        System.out.println(linkedList.toString());
        System.out.println("Size: " + linkedList.getSize());
        System.out.println("Is empty: " + linkedList.isEmpty());

        System.out.println();
        linkedList.addAtStart(20);
        System.out.println("Add 20 at start: " + linkedList.toString());
        System.out.println("Size: " + linkedList.getSize());

        System.out.println();
        System.out.println("Get by index 0: " + linkedList.get(0));
        Node<Integer> node = linkedList.getNode(0);
        System.out.println("Get node by index 0 - value: " + node.getValue() + " - next: " + node.getNext().getValue());

        System.out.println();
        linkedList.addAtPosition(2, 50);
        System.out.println("Add at position 2, element 50: " + linkedList.get(2));
        System.out.println(linkedList.toString());

        System.out.println();
        System.out.println("Index of value 3 == 4: " + linkedList.indexOf(3));
        System.out.println("Contains 50: " + linkedList.contains(50));

        System.out.println();
        System.out.println("Remove at position 0: " + linkedList.removeAtPosition(0) + " " + linkedList.toString());
        System.out.println("Remove elem 50: " + linkedList.remove(50));

        linkedList.clear();
        System.out.println("Clear list - size: " + linkedList.getSize() + ", is empty: " + linkedList.isEmpty());

    }
}
