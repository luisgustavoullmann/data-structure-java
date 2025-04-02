package search_sort.sorting;

import java.util.Arrays;

public class SelectionSort {
    // O (n*n) - O(n²) - polynomial - cubic
    public static <T extends Comparable<T>> T[] selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {20, 9, 86, -2, 16};
        System.out.println(Arrays.toString(selectionSort(nums)));

        Integer[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(selectionSort(nums2)));

        Integer[] nums3 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(Arrays.toString(selectionSort(nums3)));
    }
}
