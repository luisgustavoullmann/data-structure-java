package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fibonacci-number/submissions/1619419297/
public class Fibonacci {

    // O(2n) - exponential
    public static int fibonacciNaive(int n) {
        if (n <= 2) return 1; // base case
        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2); // recursion
    }


    // O(n) - non-recursive
    public static int fibonacciBottomUp(int n) {
        if (n <= 0) return 0;
        int[] memory = new int[n + 1];
        memory[1] = memory[2] = 1; // base case
        for (int i = 3; i <= n; i++){
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }

    // O(n) - recursive
    public static int fibonacciTopdown(int n) {
        Map<Integer, Integer> memory = new HashMap<>();
        return auxFibTopdown(memory, n);
    }

    private static int auxFibTopdown(Map<Integer, Integer> memory, int n) {
        if (memory.containsKey(n)) return memory.get(n);

        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;

        int result = auxFibTopdown(memory, n - 1) + auxFibTopdown(memory, n - 2);
        memory.put(n, result);
        return result;
    }




    public static void main(String[] args) {
        System.out.println("Fibonacci Naive: " + fibonacciNaive(6));
//        System.out.println("Fibonacci Naive: " + fibonacciNaive(50));

        System.out.println("Fibonacci Topdown: " + fibonacciTopdown(50));

        System.out.println("Fibonacci Bottomup: " + fibonacciBottomUp(50));


    }
}
