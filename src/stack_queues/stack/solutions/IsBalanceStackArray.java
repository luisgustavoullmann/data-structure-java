package stack_queues.stack.solutions;

import stack_queues.stack.array.StackArray;

import java.util.Stack;

public class IsBalanceStackArray {
    public static boolean isBalanced(String text) {
        StackArray<Character> stack = new StackArray<>();
        for (char ch : text.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(())()")); // true
        System.out.println(isBalanced("())("));   // false
    }
}
