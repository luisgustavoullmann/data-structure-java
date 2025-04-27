package dynamic_programming;


import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memory = new int[n];
        Arrays.fill(memory, 1);

        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memory[i] = Math.max(memory[i], 1 + memory[j]);
                }
            }
            result = Math.max(result, memory[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = new int[]{3,1,8,2,5};
        System.out.println("LIS 1: " + lengthOfLIS(s));

        s = new int[]{10, 4, 5, 6, 5, 15, 2, 3};
        System.out.println("LIS 2: " + lengthOfLIS(s));
    }
}
