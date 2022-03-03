package design;

import java.util.LinkedList;
import java.util.Queue;

/*
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {
    Queue<Integer> queue;
    int topElem;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        topElem = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.add(queue.poll());
            size--;
        }

        topElem = queue.peek();
        queue.add(queue.poll());
        return queue.poll();
    }

    public int top() {
        return topElem;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
