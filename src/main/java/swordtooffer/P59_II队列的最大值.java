package swordtooffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//若队列为空，pop_front 和 max_value需要返回 -1
public class P59_II队列的最大值 {
    class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                //双端队列，删除队尾节点花费时间是 O(1)
                deque.pollLast();
            }
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            if (queue.peek().equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return queue.poll();
        }
    }

}
