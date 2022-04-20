package hot100;

import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
public class P20_有效的括号 {
    //时间复杂度：O(N)
    //空间复杂度：O(1)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char c1 = stack.peek();
            char c2 = s.charAt(i);
            if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')) {
                stack.pop();
            } else {
                stack.push(c2);
            }
        }
        return stack.isEmpty();
    }
}
