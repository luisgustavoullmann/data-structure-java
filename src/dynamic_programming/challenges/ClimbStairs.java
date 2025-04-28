package dynamic_programming.challenges;

// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbStairs {
    public static int climbStairs(int n) {
        int[] memory = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memory[i] = -1;
        }
        return auxClimbStairs(n, memory);
    }

    private static int auxClimbStairs(int n, int[] memory) {
        if (memory[n] != -1) return memory[n]; //already exists
        if (n == 0 || n == 1) return 1; // base case

        memory[n] = auxClimbStairs(n - 1, memory) + auxClimbStairs(n - 2, memory);
        return memory[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("N"+n+": " + climbStairs(n));

        n = 3;
        System.out.println("N"+n+": " + climbStairs(n));

        n = 45;
        System.out.println("N"+n+": " + climbStairs(n));
    }
}
