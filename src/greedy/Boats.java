package greedy;

import java.util.Arrays;

public class Boats {
    public static int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1;

        Arrays.sort(people);

        int boats = 0;

        while (l <= r) {
            if (people[r] + people[l] <= limit) {
                l++;
                r--;
            } else if (people[r] <= limit) {
                r--;
            } else {
                l++;
            }
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
