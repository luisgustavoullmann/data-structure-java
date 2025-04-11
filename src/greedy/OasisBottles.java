package greedy;

import java.util.Arrays;

public class OasisBottles {
    public static int maximumBottles(int numBottles, int water, int[] bottles) {
        Arrays.sort(bottles);

        int resp = 0;
        for (int i = 0; i < numBottles; i++) {
            if (water - bottles[i] >= 0) {
                water -= bottles[i];
                resp++;
            } else {
                break;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(maximumBottles(5, 10, new int[] {8, 5, 4, 3, 2}));
        System.out.println(maximumBottles(3, 10, new int[] {6, 3, 2}));
    }
}
