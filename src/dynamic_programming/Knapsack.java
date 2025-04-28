package dynamic_programming;

import java.util.Arrays;

public class Knapsack {
    public static int knapsackNaive(int n, int w, int[] weights, int[] values) {
        if (n == 0 || w ==0) return 0; //base case

        if (weights[n - 1] > w){ // jumps next item if exceeds capacity
            return knapsackNaive(n - 1, w, weights, values);
        }
        else { // or include/exclude item
            int include = values[n - 1] + knapsackNaive(n - 1, w - weights[n -1], weights, values);
            int exclude = knapsackNaive(n - 1, w, weights, values);
            return Math.max(include, exclude);
        }
    }

    // O(n*w)
    public static int knapsackTopDown(int n, int w, int[] weights, int[] values) {
        int[][] memory = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memory[i], -1);
        }
        return auxKnapsackTopDown(n, w,  weights, values, memory);
    }

    private static int auxKnapsackTopDown(int n, int w, int[] weights, int[] values, int[][] memory) {
        if (n == 0 || w ==0) return 0; //base case

        if (memory[n][w] != -1) {
            return memory[n][w];
        }

        if (weights[n - 1] > w){ // jumps next item if exceeds capacity
            return auxKnapsackTopDown(n - 1, w, weights, values, memory);
        }
        else { // or include/exclude item
            int include = values[n - 1] + auxKnapsackTopDown(n - 1, w - weights[n -1], weights, values, memory);
            int exclude = auxKnapsackTopDown(n - 1, w, weights, values, memory);
            memory[n][w] = Math.max(include, exclude);
            return memory[n][w];
        }
    }

    // O(n*w)
    public static int knapsackBottomUp(int n, int W, int[] weights, int[] values) {
        int[][] memory = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memory[i], 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i -1] <= w) {
                    memory[i][w] = Math.max(memory[i -1][w], values[i -1] + memory[i -1][w - weights[i -1]]);
                } else memory[i][w] = memory[i -1][w];
            }
        }
        return memory[n][W];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3};
        int[] values = new int[]{6,10,12};
        int n = 3;
        int w = 5; // max weight/capacity

        System.out.println("Naive: " + knapsackNaive(n, w, weights, values));

        System.out.println("Topdown: " + knapsackTopDown(n, w, weights, values));

        System.out.println("Bottom Up: " + knapsackBottomUp(n, w, weights, values));
    }
}
