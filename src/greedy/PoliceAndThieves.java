package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliceAndThieves {

    public static int catchThieves(char[] arr, int n, int k) {
        List<Integer> thievesIndex = new ArrayList<>();
        List<Integer> policeIndex = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'T') thievesIndex.add(i);
            else if (arr[i] == 'P') policeIndex.add(i);
        }

        int t = 0, p = 0, resp = 0;
        while (t < thievesIndex.size() && p < policeIndex.size()) {
            int dist = Math.abs(thievesIndex.get(t) - policeIndex.get(p));
            if (dist <= k) {
                resp++;
                t++;
                p++;
            } else if (thievesIndex.get(t) < policeIndex.get(p)) {
                t++;
            } else p++;
        }

        return resp;
    }

    public static void main(String[] args) {
        System.out.println(catchThieves(new char[] {'P', 'T', 'T', 'P', 'T'}, 5, 1));
        System.out.println(catchThieves(new char[] {'T', 'T', 'P', 'P', 'T', 'P'}, 6, 2));
    }
}
