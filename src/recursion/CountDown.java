package recursion;

public class CountDown {

    public static void countDown(int n) {
        System.out.println(n);
        if (n > 0) countDown(n - 1);
    }

    public static void main(String[] args) {
        countDown(5);
    }
}
