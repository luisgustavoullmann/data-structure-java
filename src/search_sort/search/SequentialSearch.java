package search_sort.search;

import search_sort.TimeTest;

import java.time.Instant;

public class SequentialSearch {

    // O(n) - linear
    public static <T extends Comparable<T>> int sequentialSearch(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] numbers = {28, 6, -2, 9, 16, 20, 23, 8};
        System.out.println(sequentialSearch(numbers, 20)); // 5

        Integer[] otherNumbers = {4, 6, -3, 21, 55, 91, 2};
        System.out.println(sequentialSearch(otherNumbers, 11)); // -1

    }
}
