package dynamic_programming;

// https://leetcode.com/problems/maximum-subarray/
public class Kadane {
    public static int maxSubArray(int[] v) {
        int maxSum = v[0];
        int currentSum = 0;

        for (int i = 0; i < v.length; i++) {
            currentSum = Math.max(v[i], v[i] + currentSum);
            if (currentSum > maxSum) maxSum = currentSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] v = {5, -10, 2, 3, 6, -5, 7, -20, 10};

        int result = maxSubArray(v);
        System.out.println("Maximum Sum Sub Array: " + result);
    }
}
