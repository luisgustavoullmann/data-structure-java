package search_sort.search;

public class BinarySearchTailRecursive {

    public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
        return binarySearchTailRecursive(array, key, 0, array.length);
    }

    // O(log n)
    public static <T extends Comparable<T>> int binarySearchTailRecursive(T[] array, T key, int low, int high) {
       if (low > high) return -1;

       int middle = (low + high) / 2;
       int compare = key.compareTo(array[middle]);

       if (compare == 0) {
           return middle;
       } else if (compare < 0) {
           return binarySearchTailRecursive(array, key, low, middle -1);
       } else return binarySearchTailRecursive(array, key, middle + 1, high);
    }

    public static void main(String[] args) {
        Integer[] nums = {-5, 0, 2, 8, 13, 16, 19, 23, 29, 34, 38};
        System.out.println(binarySearch(nums, 34));  // 9
        System.out.println(binarySearch(nums, 10));  // -1

        Integer[] nums2 = {-10, -3, 4, 11, 13, 18, 44, 64, 91, 225, 431};
        System.out.println(binarySearch(nums2, 11)); // 3
    }
}
