package dynamic_programming;

import java.util.Arrays;

public class RodCutting {

    public static int maxRodCuttingNaive(int n, int[] p) {
        if (n == 0) return 0;
        int result = -Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if (n - i >= 0) {
                result = Math.max(result, maxRodCuttingNaive(n - i, p) + p[i - 1]);
            }
        }
        return result;
    }

    public static int maxRodCuttingTopdown(int n, int[] p) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, -1);
        return auxRodCuttingTopdown(n, p, memory);
    }

    private static int auxRodCuttingTopdown(int n, int[] p, int[] memory) {
        if (n == 0) return 0;
        if (memory[n] != -1) return memory[n];

        for (int i = 1; i <= n; i++) {
            if (n - i >= 0) {
                memory[n] = Math.max(memory[n], auxRodCuttingTopdown(n - i, p, memory) + p[i - 1]);
            }
        }
        return memory[n];
    }

    public static int maxRodCuttingBottomUp(int n, int[] p) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, -1);

        memory[0] = 0; // base case

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                memory[i] = Math.max(memory[i], memory[i - j] + p[j - 1]);
            }
        }
        return memory[n];
    }


    public static void main(String[] args) {
        int[] p = new int[]{3, 4, 8, 10, 10, 11, 23, 23, 24, 25};
        int n = 10;
        System.out.println("Naive: " + maxRodCuttingNaive(n, p));

        int[] pLarge = new int[]{3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 8, 10, 10, 11, 23, 23, 24, 25, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int nLarge = 40;
//        System.out.println("Naive: " + maxRodCuttingNaive(nLarge, pLarge)); // breaks

        System.out.println("Topdown: " + maxRodCuttingTopdown(n, p));
        System.out.println("Topdown: " + maxRodCuttingTopdown(nLarge, pLarge));

        System.out.println("Bottom up: " + maxRodCuttingBottomUp(n, p));
        System.out.println("Bottom up: " + maxRodCuttingBottomUp(nLarge, pLarge));
    }
}
