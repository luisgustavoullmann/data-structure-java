package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/coin-change/description/
public class CoinChange {

    public static int minCoinsNaive(int v, int[] c) {
        if (v == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int coin : c) {
            int subproblem = v - coin;
            if (subproblem >= 0) {
                result = Math.min(result, minCoinsNaive(subproblem, c) + 1);
            }
        }

        return result;
    }

    // O(n * v)
    public static int minCoinsTopdown(int v, int[] coins) {
        Map<Integer, Integer> memory = new HashMap<>();
        return auxMinCoinsTopdown(memory, v, coins);
    }

    private static int auxMinCoinsTopdown(Map<Integer, Integer> memory, int v, int[] coins) {
        if (memory.containsKey(v)) return memory.get(v);
        if (v == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subproblem = v - coin;
            if (subproblem >= 0) {
                result = Math.min(result, auxMinCoinsTopdown(memory, subproblem, coins) + 1);
            }
        }
        memory.put(v, result);
        return result;
    }

    // O(v * n)
    public static int minCoinsBottomUp(int v, int[] coins) {
        int[] memory = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            memory[i] = Integer.MAX_VALUE;
        }

        memory[0] = 0;

        for (int i = 1; i <= v; i++) {
            for (int coin : coins) {
                int subproblem = i - coin;
                if (subproblem >= 0 && memory[subproblem] != Integer.MAX_VALUE) {
                    memory[i] = Math.min(memory[i], memory[subproblem] + 1);
                }
            }
        }

        return memory[v] == Integer.MAX_VALUE ? -1 : memory[v];
    }




    public static void main(String[] args) {
        int[] coins = {1, 2, 5};  // coins
        int value = 11;

        int result = minCoinsNaive(value, coins);
        System.out.println("Naive = Min coins " + value + " is: " + result);

        value = 1000;
        result = minCoinsTopdown(value, coins);
        System.out.println("Topdown = Min coins " + value + " is: " + result);

        value = 10000;
        result = minCoinsBottomUp(value, coins);
        System.out.println("Bottom Up = Min coins " + value + " is: " + result);
    }
}
