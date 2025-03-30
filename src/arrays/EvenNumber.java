package arrays;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class EvenNumber {

    public static int findEven(int[] nums) {
        int countEvenNumber = 0;

        for (int value : nums) {
            int numDigits = String.valueOf(value).length();
            if (numDigits % 2 == 0) {
                countEvenNumber++;
            }
        }
        return countEvenNumber;
    }

    public static void main(String[] args) {
        System.out.println(findEven(new int[]{12, 345, 2, 6, 7896}));  // 2
        System.out.println(findEven(new int[]{555, 901, 482, 1771}));  // 1
    }
}
