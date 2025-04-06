package lists.doubly_linked_list;

public class MainDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addAtEnd(5);
        System.out.println("Add at end: " + list);

        list.addAtStart(10);
        System.out.println("Add at start: " + list.toString());
        System.out.println("Size: " + list.getSize());
        System.out.println("Get by index 0: " + list.get(0));
        System.out.println("Index of: " + list.indexOf(10));
        System.out.println("Contains 50: " + list.indexOf(50));

        System.out.println("Adding 50 to doubly list");
        list.addAtEnd(50);
        System.out.println("Current list: " + list.toString());
        System.out.println("Contains 50: " + list.contains(50));
        System.out.println("Contains 50: " + list.indexOf(50));

        System.out.println("Remove head: " + list.removeHead());
        System.out.println("Remove tail: " + list.removeTail());

        list.addAtStart(10);
        list.addAtEnd(50);
        list.addAtEnd(100);
        list.addAtEnd(20);
        list.addAtEnd(1);
        System.out.println("Current list: " + list.toString());

        System.out.println("Remove at position 2: " + list.removeAtPosition(2));

        System.out.println("Current list: " + list.toString());
        System.out.println("Just remove 1: " + list.remove(1));
        System.out.println("Current list: " + list.toString());
        list.reverse();
        System.out.println("Reverse list: " + list.toString());

    }
}
