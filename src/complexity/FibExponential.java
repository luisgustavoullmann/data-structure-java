package complexity;

public class FibExponential {

    // O(2n) - exponential - time
    public static int fibonacciExponential(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacciExponential(n - 1) + fibonacciExponential(n - 2);
    }

    public static void main(String[] args) {
        int result = fibonacciExponential(40);
        System.out.println(result);
    }
}
