package graphs.adj_list;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<int[]> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public MinHeap(List<int[]> heap) {
        this.heap = heap;
    }

    public void insert(int[] node) {
        heap.add(node);
        bubbleUp();
    }

    public int[] extractMin() {
        if (heap.size() == 1) {
            return heap.removeFirst();
        }
        int[] min = heap.getFirst();
        heap.set(0, heap.removeLast());
        bubbleDown();
        return min;
    }

    private void bubbleUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex)[1] <= heap.get(index)[1]) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void bubbleDown() {
        int index = 0;
        int lenght = heap.size();

        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < lenght && heap.get(leftChild)[1] < heap.get(smallest)[1]) {
                smallest = leftChild;
            }

            if (rightChild < lenght && heap.get(rightChild)[1] < heap.get(smallest)[1]) {
                smallest = rightChild;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int[] temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

