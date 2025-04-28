package dynamic_programming.challenges;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-falling-path-sum/description/
public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int INF = Integer.MAX_VALUE;
        int[][] memory = new int[n][n];

        // init first line
        for (int j = 0; j < n; j++) {
            memory[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int path_a = INF;
                int path_b = INF;
                int path_c = INF;

                if (isValid(i - 1, j - 1, n)) {
                    path_a = matrix[i][j] + memory[i - 1][j - 1];
                }

                if (isValid(i - 1, j + 1, n)) {
                    path_b = matrix[i][j] + memory[i - 1][j + 1];
                }

                if (isValid(i - 1, j, n)) {
                    path_c = matrix[i][j] + memory[i - 1][j];
                }

                memory[i][j] = Math.min(path_a, Math.min(path_b, path_c));
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, memory[n - 1][j]);
        }

        return result;
    }

    private static boolean isValid(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }


    public static void main(String[] args) {
        int[][] matrix = {
            {2,1,3},
            {6,5,4},
            {7,8,9}
        };

        System.out.println(minFallingPathSum(matrix));

        int[][] matrix2 = {
                {-19,57},
                {-40,-5}
        };

        System.out.println(minFallingPathSum(matrix2));
    }
}
