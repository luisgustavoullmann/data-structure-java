package dynamic_programming.challenges;

import java.util.Arrays;

public class PreciousStones {
    public static int maxProfitTopdown(int n, int[] values) {
        int[] memory = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memory, -1);
        }

        return auxMaxProfitTopdown(n, values, memory);
    }

    private static int auxMaxProfitTopdown(int n, int[] values, int[] memory) {
        if (n == 0) return 0; // base case
        if (memory[n] != -1) return memory[n]; // already exists

        memory[n] = 0; // init

        for (int i = 1; i <= n; i++) {
            if (n - i >= 0) {
                memory[n] = Math.max(memory[n],
                        auxMaxProfitTopdown(n - i, values, memory) + values[i - 1]);
            }
        }
        return memory[n];
    }

    public static int maxProfitBottomUp(int n, int[] values) {
        int[] memory = new int[n + 1];
        memory[0] = 0; // init

        for (int i = 1; i <= n; i++) {
            memory[i] = 0;
            for (int j = 1; j <= i; j++) {
                memory[i] = Math.max(memory[i], memory[i - j] + values[j -1]);
            }
        }
        return memory[n];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] values = new int[]{2,5,7,9};
        System.out.println("Topdown for "+n+": " + maxProfitTopdown(n, values));
        System.out.println("Bottom Up for "+n+": " + maxProfitBottomUp(n, values));

        n = 8;
        values = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Topdown for "+n+": " + maxProfitTopdown(n, values));
        System.out.println("Bottom Up for "+n+": " + maxProfitBottomUp(n, values));

        values = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Topdown for "+n+": " + maxProfitTopdown(n, values));
        System.out.println("Bottom Up for "+n+": " + maxProfitBottomUp(n, values));    }
}
