package recursion;

import java.util.Arrays;
import java.util.List;

public class SumList {

    public static double sumList(List<Double> list) {
        return sumListTailRecursive(list, 0);
    }

    private static double sumListTailRecursive(List<Double> list, double total) {
        if (list.isEmpty()) return total;
        return sumListTailRecursive(list.subList(1, list.size()), total + list.get(0));
    }

//    public static double sumList(List<Double> list) {
//        if (list.isEmpty()) return 0;
//
//        double head = list.get(0);
//        List<Double> tail = new ArrayList<>(list.subList(1, list.size()));
//
//        return head + sumList(tail);
//    }



    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(4.0, 5.0, 3.0);
        System.out.println("Result = " + sumList(numbers));
    }
}
