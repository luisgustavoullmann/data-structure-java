package stack_queues.queues;

public class MainQueueList {
    public static void main(String[] args) {
        QueueList<Integer> queue = new QueueList<>();

        System.out.println("Count: " + queue.count());
        System.out.println("Is empty: " + queue.isEmpty());

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue);
        System.out.println("Peek: " + queue.peek());
        queue.remove();
        System.out.println("Removed first element: " + queue.toString());
    }
}
