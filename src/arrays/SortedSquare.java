package arrays;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/description/
public class SortedSquare {

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
