package recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeList {

    public static <T> List<T> mergeLists(List<T> a, List<T> b) {
        if (a.isEmpty()) return b;
        if (b.isEmpty()) return a;

        T headA = a.get(0);
        List<T> tailA = new ArrayList<>(a.subList(1, a.size()));

        T headB = b.get(0);
        List<T> tailB = new ArrayList<>(b.subList(1, a.size()));

        List<T> result = new ArrayList<>();
        result.add(headA);
        result.add(headB);
        result.addAll(mergeLists(tailA, tailB));
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(10, 20, 30);
        List<Integer> list2 = List.of(5, 8, 7);
        System.out.println(mergeLists(list1, list2));

        List<String> list3 = List.of("ana", "maria");
        List<String> list4 = List.of("joao", "bob", "alex", "leo");
        System.out.println(mergeLists(list3, list4));
    }
}
