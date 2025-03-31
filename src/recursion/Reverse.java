package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {

    public static <T> List<T> reverseList(List<T> list) {
        if (list.size() <= 1) {
            return new ArrayList<>(list);
        }

        T head = list.get(0); // first element
        List<T> tail = list.subList(1, list.size());

        List<T> newList = new ArrayList<>(reverseList(tail)); // tail reverse
        newList.add(head); // adding head at the end

        return newList;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Moe", "Larry", "Joe", "Homer");
        System.out.println("Original: " + list);
        System.out.println("Result: " + reverseList(list));
    }
}
