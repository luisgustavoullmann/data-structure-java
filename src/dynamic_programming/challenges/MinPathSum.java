package dynamic_programming.challenges;

// https://leetcode.com/problems/minimum-path-sum/submissions/1619528197/
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] memory = new int[n][m];
        memory[0][0] = grid[0][0]; // initial position

        // first columns
        for (int i = 1; i < n; i++){
            memory[i][0] = memory[i - 1][0] + grid[i][0];
        }

        // first line
        for (int j = 1; j < m; j++) {
            memory[0][j] = memory[0][j - 1] + grid[0][j];
        }

        // table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memory[i][j] = Math.min(memory[i - 1][j], memory[i][j - 1]) + grid[i][j];
            }
        }

        return memory[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println("Minimum path sum: " + minPathSum(grid));
    }
}
