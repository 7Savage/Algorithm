package hot;

import java.util.Stack;

public class P20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            char c2 = s.charAt(i);
            char c1 = stack.peek();
            if ((c1=='('&& c2 ==')') || (c1 == '[' && c2 ==']') || (c1 == '{' && c2 == '}')) {
                stack.pop();
            } else {
                stack.push(c2);
            }
        }
        return stack.isEmpty();
    }
}
