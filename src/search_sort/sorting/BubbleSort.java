package search_sort.sorting;

import java.util.Arrays;

public class BubbleSort {
    // O (n*n) - O(n²) - polynomial - cubic
    public static <T extends Comparable<T>> T[] bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
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
        System.out.println(Arrays.toString(bubbleSort(nums)));

        Integer[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSort(nums2)));

        Integer[] nums3 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(Arrays.toString(bubbleSort(nums3)));
    }
}
