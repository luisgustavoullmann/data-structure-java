package dynamic_programming.challenges;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/coin-change/description/
public class CoinChange {

    public static int minCoinsNaive(int amount, int[] c) {
        if (amount == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int coin : c) {
            int subproblem = amount - coin;
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

    private static int auxMinCoinsTopdown(Map<Integer, Integer> memory, int amount, int[] coins) {
        if (memory.containsKey(amount)) return memory.get(amount);
        if (amount == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subproblem = amount - coin;
            if (subproblem >= 0) {
                result = Math.min(result, auxMinCoinsTopdown(memory, subproblem, coins) + 1);
            }
        }
        memory.put(amount, result);
        return result;
    }

    // O(amount * n)
    public static int minCoinsBottomUp(int amount, int[] coins) {
        int[] memory = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            memory[i] = Integer.MAX_VALUE;
        }

        memory[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int subproblem = i - coin;
                if (subproblem >= 0 && memory[subproblem] != Integer.MAX_VALUE) {
                    memory[i] = Math.min(memory[i], memory[subproblem] + 1);
                }
            }
        }

        return memory[amount] == Integer.MAX_VALUE ? -1 : memory[amount];
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
