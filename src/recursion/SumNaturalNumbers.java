package recursion;

public class SumNaturalNumbers {

    public static int sumNaturals(int n) {
        if (n == 0) { // stop criteria or base case
            return 0;
        }

        System.out.println(n);
        return n * sumNaturals(n - 1); // recursive case
    }

    public static void main(String[] args) {
        System.out.println(sumNaturals(4));
    }
}
