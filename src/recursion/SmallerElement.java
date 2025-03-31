package recursion;

import java.util.ArrayList;
import java.util.List;

public class SmallerElement {

    public static double minor(List<Double> list) {
        if (list.size() <= 1) return list.get(0);

        double head = list.get(0);
        List<Double> tail = new ArrayList<>(list.subList(1, list.size()));

        double tailMinor = minor(tail);

        return Math.min(head, tailMinor);
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(10.0, 15.0, 20.0, 8.0, 30.0, 17.0));
        double result = minor(list);
        System.out.println("Minor = " + result);
    }
}
