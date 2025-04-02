package search_sort.sorting;

import java.util.Arrays;

public class InsertionSort {

    // O (n*n) - O(n²) - polynomial - cubic
    public static <T extends Comparable<T>> T[] insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T aux = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(aux) > 0) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = aux;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] nums = {20, 9, 86, -2, 16};
        System.out.println(Arrays.toString(insertionSort(nums)));

        Integer[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(insertionSort(nums2)));

        Integer[] nums3 = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(Arrays.toString(insertionSort(nums3)));
    }
}
