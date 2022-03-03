package hot100;

import java.util.Stack;

public class P155_最小栈 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (!minStack.isEmpty()) {
                if (val <= minStack.peek()) {
                    minStack.push(val);
                }
            } else {
                minStack.push(val);
            }
        }

        public void pop() {
            if (minStack.peek().equals(stack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
