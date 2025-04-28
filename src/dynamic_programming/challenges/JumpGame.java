package dynamic_programming.challenges;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game/
public class JumpGame {

    public static boolean canJumpTopDown(int[] nums) {
        int[] memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return auxCanJumpTopDown(0, nums, memory);
    }

    private static boolean auxCanJumpTopDown(int position, int[] nums, int[] memory) {
        if (position == nums.length -1) return true;
        if (memory[position] != -1) return memory[position] == 1; // base case

        int furthestJump = Math.min(position + nums[position], nums.length -1);
        for (int next = position + 1; next <= furthestJump; next++) {
            if (auxCanJumpTopDown(next, nums, memory)) {
                memory[position] = 1;
                return true;
            }
        }
        memory[position] = 0;
        return false;
    }


    public static boolean canJumpBottomUp(int[] nums) {
        int n = nums.length;
        int[] memory = new int[n];
        Arrays.fill(memory, -1);

        memory[n - 1] = 1; // 1 finish; 0 doesn't finish

        for (int i = n - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], n -1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memory[j] == 1) {
                    memory[i] = 1;
                    break;
                }
            }
            if (memory[i] != 1) memory[i] = 0;
        }
        return memory[0] == 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println("Jump 1: " + canJumpTopDown(nums));
        System.out.println("Jump 1: " + canJumpBottomUp(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println("Jump 2: " + canJumpTopDown(nums));
        System.out.println("Jump 2: " + canJumpBottomUp(nums));

    }
}
