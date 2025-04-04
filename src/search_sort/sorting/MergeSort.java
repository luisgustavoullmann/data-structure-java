package search_sort.sorting;

import java.util.Arrays;

public class MergeSort {
    // O(n log(n)) - logarithmic
    public static <T extends Comparable<T>> T[] mergeSort(T[] arr) {
        mergeSortTailRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    public static <T extends Comparable<T>> void mergeSortTailRecursive(T[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortTailRecursive(arr, left, middle);
            mergeSortTailRecursive(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        Object[] result = new Object[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (arr[i].compareTo(arr[j]) < 0) {
                result[k++] = arr[i++];
            } else result[k++] = arr[j++];
        }

        while (i <= middle) {
            result[k++] = arr[i++];
        }

        while (j <= right) {
            result[k++] = arr[j++];
        }

        for (i = 0; i < result.length; i++) {
            arr[left + i] = (T) result[i];
        }
    }

    public static void main(String[] args) {
        Integer[] nums1 = { 20, 9, 86, -2, 16 };
        Integer[] nums2 = { 30, 24, -2, 2, -4, -2, 2, 8, 10, 9, -4 };
        Integer[] nums3 = { 1, 1, 1, 2, 2, 4, 8, 8, 16, 32 };

        System.out.println(Arrays.toString(mergeSort(nums1)));
        System.out.println(Arrays.toString(mergeSort(nums2)));
        System.out.println(Arrays.toString(mergeSort(nums3)));
    }
}
