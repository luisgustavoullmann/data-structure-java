package dynamic_programming;

import java.util.Arrays;

// Longest Common Subsequence
// https://leetcode.com/problems/longest-common-subsequence/description/
public class LCS {

    public static int lcsNaive(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        return findLcsNaive(n -1, m -1, s1, s2);
    }

    private static int findLcsNaive(int ind1, int ind2, String s1, String s2) {
        if (ind1 < 0 || ind2 < 0) return 0; // base case

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + findLcsNaive(ind1 -1, ind2 -1, s1, s2);
        } else {
            return Math.max(
                    findLcsNaive(ind1 -1, ind2, s1,s2),
                    findLcsNaive(ind1, ind2 -1, s1,s2)
            );
        }
    }

    public static int lcsTopdown(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] memory = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memory[i], -1);
        }

        return findLcsTopdown(n -1, m -1, s1, s2, memory);
    }

    private static int findLcsTopdown(int ind1, int ind2, String s1, String s2, int[][] memory) {
        if (ind1 < 0 || ind2 < 0) return 0; // base case

        if (memory[ind1][ind2] != -1) return memory[ind1][ind2]; // already exists

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            memory[ind1][ind2] = 1 + findLcsTopdown(ind1 -1, ind2 -1, s1, s2, memory);
        } else {
            memory[ind1][ind2] = Math.max(
                    findLcsTopdown(ind1 -1, ind2, s1,s2, memory),
                    findLcsTopdown(ind1, ind2 -1, s1,s2, memory)
            );
        }
        return memory[ind1][ind2];
    }

    public static int lcsBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        int[][] memory = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memory[i], 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1Char[i -1] == s2Char[j -1]) {
                    memory[i][j] = 1 + memory[i -1][j -1];
                } else {
                    memory[i][j] = Math.max(memory[i -1][j], memory[i][j -1]);
                }
            }
        }

        return memory[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println("Case 1: " + s1 + " " + s2);
        System.out.println("Naive: " + lcsNaive(s1, s2));
        System.out.println("Topdown: " + lcsTopdown(s1, s2));
        System.out.println("Bottom Up: " + lcsBottomUp(s1, s2));
        System.out.println();

        s1 = "abc";
        s2 = "def";
        System.out.println("Case 2: " + s1 + " " + s2);
        System.out.println("Naive: " + lcsNaive(s1, s2));
        System.out.println("Topdown: " + lcsTopdown(s1, s2));
        System.out.println("Bottom Up: " + lcsBottomUp(s1, s2));
        System.out.println();

        s1 = "abcdef";
        s2 = "abcdef";
        System.out.println("Case 3: " + s1 + " " + s2);
        System.out.println("Topdown: " + lcsTopdown(s1, s2));
        System.out.println("Bottom Up: " + lcsBottomUp(s1, s2));
        System.out.println("Naive: " + lcsNaive(s1, s2));
        System.out.println();

        s1 = "aaaaaaaaaaaaaaaaaaabcdef";
        s2 = "abcdefaaaaaaaaaaaaaaaaaaa";
        System.out.println("Case 4: " + s1 + " " + s2);
        System.out.println("Topdown: " + lcsTopdown(s1, s2));
        System.out.println("Bottom Up: " + lcsBottomUp(s1, s2));
        System.out.println("Naive: " + lcsNaive(s1, s2));
    }
}
