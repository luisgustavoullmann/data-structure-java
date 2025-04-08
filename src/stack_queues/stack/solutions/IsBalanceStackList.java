package stack_queues.stack.solutions;

import stack_queues.stack.list.StackList;

public class IsBalanceStackList {
    public static boolean isBalanced(String text) {
        StackList<Character> stack = new StackList<>();
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
