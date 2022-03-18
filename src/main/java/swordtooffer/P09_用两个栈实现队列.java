package swordtooffer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
  */
public class P09_用两个栈实现队列 {
    //慢
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }

        public int deleteHead() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek() == null ? -1 : stack2.pop();
        }
    }


    /**
     * 快一点的方法
     * 时间复杂度： appendTail()函数为 O(1) ；deleteHead() 函数在 N 次队首元素删除操作中总共需完成 N 个元素的倒序。
     * 空间复杂度 O(N) ： 最差情况下，栈 A 和 B 共保存 N 个元素。
     */
    public class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
