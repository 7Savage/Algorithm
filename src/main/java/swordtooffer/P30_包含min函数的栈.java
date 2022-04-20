package swordtooffer;

import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
public class P30_包含min函数的栈 {
    //时间复杂度：O(1)
    //空间复杂度：O(N)
    class MinStack {

        Stack<Integer> A;
        Stack<Integer> B;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.push(x);
            //非严格单调
            if (B.isEmpty() || x <= B.peek()) {
                B.push(x);
            }
        }

        public void pop() {
            if (A.pop().equals(B.peek())) {
                B.pop();
            }
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }
}
