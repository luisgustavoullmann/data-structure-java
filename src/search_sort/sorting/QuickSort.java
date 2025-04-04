package search_sort.sorting;

import java.util.Arrays;

public class QuickSort {
    // O (n*n) - O(n²) - polynomial - cubic
    public static <T extends Comparable<T>> T[] quickSort(T[] arr) {
        quickSortTailRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    public static <T extends Comparable<T>> void quickSortTailRecursive(T[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSortTailRecursive(arr, left, pivot - 1);
            quickSortTailRecursive(arr, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        T aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }

    public static void main(String[] args) {
        Integer[] array1 = {20, 9, 86, -2, 16};
        Integer[] array2 = {30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4};
        Integer[] array3 = {1, 1, 1, 2, 2, 4, 8, 8, 16, 32};

        System.out.println(Arrays.toString(quickSort(array1)));
        System.out.println(Arrays.toString(quickSort(array2)));
        System.out.println(Arrays.toString(quickSort(array3)));
    }
}
