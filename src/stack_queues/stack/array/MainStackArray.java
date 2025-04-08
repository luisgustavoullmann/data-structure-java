package stack_queues.stack.array;

public class MainStackArray {
    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>(10);

        System.out.println("Count: " + stack.count());
        System.out.println("Is empty: " + stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Count: " + stack.count());
        System.out.println("Is empty: " + stack.isEmpty());

        System.out.println("Peek: " + stack.peek());

        System.out.println("Items: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        stack.clear();
    }
}
