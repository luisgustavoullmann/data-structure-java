package recursion;

public class Fibonacci {

    public static int fibonacci(int n) {
        return fibonacciTailRecursive(n, 0, 1);
    }

    // fib(N) = fib(N - 1) + fib(N - 2) - exponential
    // total -> recursive fib of the last value of fib
    // O(n) -> linear - fibonacciTailRecursive
    public static int fibonacciTailRecursive(int n, int init, int total) {
        if (n == 0) return init; // base case;
        if (n == 1) return total; // total fibonacci sum
        return fibonacciTailRecursive(n - 1, total, init + total);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Fibonacci "+n+": " + fibonacci(n));

        n = 40;
        System.out.println("Fibonacci "+ n +": " + fibonacci(n));
    }
}
