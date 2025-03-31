package recursion;

public class Factorial {

    public static int factorial(int n) {
        if (n == 0) return 1; // base case
        return n * factorial(n - 1); // recursive case
    }

    public static void main(String[] args) {
        var n = 5;
        System.out.println("Factorial " + n + "! : " + factorial(5));
    }
}
