package greedy;
public class LargestNumberPossible {

    public static String findLargest(int num, int sumDigits) {
        String resp = "";

        // if we put the maximum digits we still can't make sumDigits
        if (9 * num < sumDigits || (sumDigits == 0 && num > 1)) {
            return "-1";
        }

        char digit;
        while (sumDigits > 0) {
            if (sumDigits - 9 >= 0) { // greedily fit as many '9' digits as we can
                sumDigits -= 9;
                digit = '9';
            } else { // fit the rest of the sum
                digit = (char)sumDigits;
                digit += '0';
                sumDigits = 0;
            }
            resp += digit;
        }

        while (resp.length() < num) { // greedily fit as many '9' digits as we can
            resp += '0';
        }

        return resp;
    }

    public static void main(String[] args) {
        System.out.println(findLargest(2, 9));
        System.out.println(findLargest(3, 20));
        System.out.println(findLargest(4, 0));
    }
}
