package stack_queues.stack.linkedlist;

import lists.linked_list.LinkedList;

public class MainStackLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

        System.out.println("Count: " + stack.getSize());
        System.out.println("Is empty: " + stack.isEmpty());

        stack.addAtEnd(1);
        stack.addAtEnd(2);
        stack.addAtEnd(3);
        stack.addAtEnd(4);

        System.out.println("Count: " + stack.getSize());
        System.out.println("Is empty: " + stack.isEmpty());

        System.out.println("Peek: " + stack.get(stack.getSize() -1));

        System.out.println("Items: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.removeAtPosition(stack.getSize() - 1));
        }

        stack.clear();
    }
}
