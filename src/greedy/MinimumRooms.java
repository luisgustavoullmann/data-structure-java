package greedy;

import java.util.Arrays;

public class MinimumRooms {
    public static int minimumRooms(int[] start, int[] end, int n) {
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0, resp = 0, rooms = 0;

        while (i < n || j < n) {
            if (i < n && (j == n || start[i] <= end[j])) {
                i++;
                rooms++;
            } else {
                j++;
                rooms--;
            }

            resp = Math.max(resp, rooms);
        }

        return resp;
    }

    public static void main(String[] args) {
        System.out.println(minimumRooms(
                new int[] {900, 940, 950, 1100, 1500, 1800},
                new int[] {910, 1200, 1120, 1130, 1900, 2000},
                6));

        System.out.println(minimumRooms(
                new int[] {900, 1100, 1235},
                new int[] {1000, 1200, 1240},
                3));
    }
}
