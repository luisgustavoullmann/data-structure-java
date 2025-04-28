package dynamic_programming.challenges;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
    public static int minCostClimbingStarsTopdown(int[] cost) {
        int[] memory = new int[cost.length + 1];
        for (int i = 0; i <= cost.length; i++) {
            Arrays.fill(memory, -1);
        }
        return auxMinCostClimbingStars(cost.length, cost, memory);
    }

    private static int auxMinCostClimbingStars(int n ,int[] cost, int[] memory) {
        if (n == 0 || n == 1) return 0; // base case
        if (memory[n] != -1) return memory[n]; // already exists

        memory[n] = Math.min(
                auxMinCostClimbingStars(n -1, cost, memory) + cost[n -1],
                auxMinCostClimbingStars(n -2, cost, memory) + cost[n - 2]
        );
        return memory[n];
    }

    public static int minCostClimbingStarsBottomUp(int[] cost) {
        int n = cost.length;
        int[] memory = new int[n + 1];

        memory[0] = 0; // cost position 0
        memory[1] = 0; // cost position 1

        for (int i = 2; i <= n; i++) {
            memory[i] = Math.min(
                    memory[i - 1] + cost[i - 1],
                    memory[i - 2] + cost[i - 2]
            );
        }
        return memory[n];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10,15,20};
        System.out.println("Topdown - Cost 1: " + minCostClimbingStarsTopdown(cost));
        System.out.println("Bottom Up - Cost 1: " + minCostClimbingStarsBottomUp(cost));

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Topdown - Cost 2: " + minCostClimbingStarsTopdown(cost));
        System.out.println("Bottom Up - Cost 2: " + minCostClimbingStarsBottomUp(cost));
    }
}
