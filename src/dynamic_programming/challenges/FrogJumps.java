package dynamic_programming.challenges;

import java.util.Arrays;
import java.util.Map;

public class FrogJumps {
    public static int minCostFrogJumpBottomUp(int[] heights) {
        int n = heights.length;
        int[] memory = new int[n];

        memory[0] = 0; // initial cost

        for (int i = 1; i < n; i++) {
            int jump1 = memory[i -1] + Math.abs(heights[i] - heights[i - 1]);
            int jump2 = (i > 1) ?
                    memory[i - 2] + Math.abs(heights[i] - heights[i - 2]) :
                    Integer.MAX_VALUE;

            memory[i] = Math.min(jump1, jump2);
        }
        return memory[n - 1];
    }


    public static int minCostFrogJumpTopDown(int[] heights) {
        int n = heights.length;
        int[] memory = new int[n];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memory, -1);
        }
        return auxMinCostFrogJumpTopDown(0, n, heights, memory);
    }

    private static int auxMinCostFrogJumpTopDown(int ind, int n, int[] heights, int[] memory) {
        if (ind >= n) return Integer.MAX_VALUE;
        if (ind == n -1) return 0; // base case
        if (memory[ind] != -1) return memory[ind]; // already exists

        int jump1 = (ind + 1 < n) ?
                auxMinCostFrogJumpTopDown(ind + 1, n, heights, memory) + Math.abs(heights[ind] - heights[ind + 1])
                : Integer.MAX_VALUE;

        int jump2 = (ind + 2 < n) ?
                auxMinCostFrogJumpTopDown(ind + 2, n, heights, memory) + Math.abs(heights[ind] - heights[ind + 2])
                : Integer.MAX_VALUE;

        memory[ind] = Math.min(jump1, jump2);
        return memory[ind];
    }

    public static void main(String[] args) {
        int[] heights = new int[]{10, 30, 40, 20};
        System.out.println("1: " + minCostFrogJumpBottomUp(heights)); // 30
        System.out.println("1: " + minCostFrogJumpTopDown(heights));

        heights = new int[]{10, 10}; // 0
        System.out.println("2: " + minCostFrogJumpBottomUp(heights));
        System.out.println("2: " + minCostFrogJumpTopDown(heights));

        heights = new int[]{30, 10, 60, 10, 60, 50}; // 40
        System.out.println("3: " + minCostFrogJumpBottomUp(heights));
        System.out.println("3: " + minCostFrogJumpTopDown(heights));
    }
}
