package complexity;

public class SequentialSearch {

    // O(n) - linear - time
    // O(1) - constant - memory space
    public static int sequentialSearch( int elem, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i; // returns position, not the value
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {15, 82, 79, 32, 41, 28};
        int result = sequentialSearch(32, array);
        System.out.println(result);

        result = sequentialSearch(500, array);
        System.out.println(result);
    }
}
