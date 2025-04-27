package dynamic_programming;

// https://leetcode.com/problems/unique-paths/
public class UniquePath {
    public static int uniquePathNaive(int i, int j) {
        if (i == 0 || j == 0) return 1;
        int moveUp = uniquePathNaive(i -1, j);
        int moveLeft = uniquePathNaive(i, j - 1);
        return moveUp + moveLeft;
    }

    public static int uniquePathTopdown(int n, int m) {
        int[][] memory = new int[n][m];

        // fill table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memory[i][j] = -1;
            }
        }

        return auxUniquePathTopdown(memory, n - 1, m - 1);
    }

    private static int auxUniquePathTopdown(int[][] memory, int i, int j) {
        if (memory[i][j] != -1) return memory[i][j]; // already exists
        if (i == 0 || j == 0) return 1; // base case

        int moveUp = auxUniquePathTopdown(memory, i - 1, j);
        int moveLeft = auxUniquePathTopdown(memory, i, j - 1);

        memory[i][j] = moveUp + moveLeft;
        return memory[i][j];
    }


    public static int uniquePathBottomUp(int n, int m) {
        int[][] memory = new int[n][m];

        for (int i = 0; i < n; i++) {
            memory[i][0] = 1;
        }

        for (int j = 0; j < m; j++) {
            memory[0][j] = 1;
        }

        // fill memory
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                memory[i][j] = memory[i - 1][j] + memory[i][j - 1];
            }
        }

        return memory[n - 1][m - 1];
    }


    public static void main(String[] args) {
        int n = 10;
        int m = 10;
//        n = 25; break
//        m = 25;
        System.out.println("Naive :" + uniquePathNaive(n, m));

        n = 50;
        m = 50;
        System.out.println("Topdown :" + uniquePathTopdown(n, m));

        n = 50;
        m = 50;
        System.out.println("Bottom Up :" + uniquePathBottomUp(n, m));
    }
}
