package recursion;

public class FactorialTailRecursive {

    public static int factorial(int n) {
        var init = 1;
        return factorialTailRecursive(n, init); // recursive case
    }

    public static int factorialTailRecursive(int n, int total) {
        if (n == 0) return total; // base case
        return factorialTailRecursive(n - 1, n * total); // tail recursive case
    }

    public static void main(String[] args) {
        var n = 5;
        System.out.println("Factorial " + n + "! : " + factorial(n));

        n = 4;
        System.out.println("Factorial " + n + "! : " + factorial(n));
    }
}
