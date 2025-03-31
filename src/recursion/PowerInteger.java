package recursion;

public class PowerInteger {

    public static int power(int a, int b) {
        return powerIntegerTailRecursive(a, b, 1);
    }

//    private static int powerIntegerTailRecursive(int a, int b) {
//        if (b == 0) return 1;
//        return a * powerIntegerTailRecursive(a, b - 1);
//    }

    private static int powerIntegerTailRecursive(int a, int b, int total) {
        if (b == 0) return total;
        return powerIntegerTailRecursive(a, b - 1, total * a);
    }

    public static void main(String[] args) {
        System.out.println(power(5, 0));
        System.out.println(power(3, 4));
    }
}
