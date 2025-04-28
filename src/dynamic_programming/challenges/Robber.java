package dynamic_programming.challenges;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/description/
public class Robber {
    public static int robTopdown(int[] nums) {
        int[] memory = new int[nums.length + 1];
        Arrays.fill(memory, -1);
        return auxRobTopdown(nums, nums.length - 1, memory);
    }

    private static int auxRobTopdown(int[] nums, int i, int[] memory) {
        if (i < 0) return 0; //base case
        if (memory[i] >= 0) return memory[i]; // already exists

        int result = Math.max(
                auxRobTopdown(nums, i - 2, memory) + nums[i],
                auxRobTopdown(nums, i - 1, memory)
                );
        memory[i] = result;
        return result;
    }

    public static int robBottomUp(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // base case
        if (n == 1) return nums[0];

        int[] memory = new int[n];
        memory[0] = nums[0]; // init
        memory[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            memory[i] = Math.max(memory[i - 1], memory[i - 2] + nums[i]);
        }

        return memory[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int[] nums2 = new int[]{2,7,9,3,1};

        System.out.println("Topdown - Nums 1: " + robTopdown(nums));
        System.out.println("Topdown - Nums 2: " + robTopdown(nums2));

        System.out.println("Bottom Up - Nums 1: " + robBottomUp(nums));
        System.out.println("Bottom Up - Nums 2: " + robBottomUp(nums2));
    }
}
