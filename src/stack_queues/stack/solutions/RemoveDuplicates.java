package stack_queues.stack.solutions;

import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicates(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else stack.push(c);
        }

        char[] result = new char[stack.size()];
        for (int i = result.length -1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }
}
