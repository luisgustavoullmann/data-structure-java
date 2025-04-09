package hash.map.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/submissions/1601952185/
public class TwoSum {

    // O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];

            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result[0] = index;
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[] {3,5,7,2,4,8,1,6}, 15)));
    }
}
