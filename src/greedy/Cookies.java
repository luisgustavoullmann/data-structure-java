package greedy;

import java.util.Arrays;

public class Cookies {
    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);

        int j = 0, resp = 0;

        // for each child
        for (int i = 0; i < children.length; i++) {
            // try to find a cookie that fits
            while (j < cookies.length && cookies[j] < children[i]) {
                j++;
            }
            // if there's cookies no more cookies
            if (j == cookies.length) {
                break;
            } else {
                resp++;
                j++;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[] {1, 1}));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[] {2, 3}));
    }
}
