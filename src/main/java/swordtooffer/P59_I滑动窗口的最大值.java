package swordtooffer;

import java.util.*;

public class P59_I滑动窗口的最大值 {
    //时间复杂度 O(n) ： 其中 n 为数组 nums 长度；线性遍历 nums 占用 O(n)；每个元素最多仅入队和出队一次，因此单调队列 deque 占用 O(2n) 。
    //空间复杂度 O(k) ： 双端队列 deque 中最多同时存储 k 个元素（即窗口大小）。
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < k-1; i++) {
            window.push(nums[i]);
        }
        for (int i = k-1; i < nums.length; i++) {
            window.push(nums[i]);
            list.add(window.max());
            window.pop(nums[i - k + 1]);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    class MonotonicQueue {

        Deque<Integer> deque;

        public MonotonicQueue() {
            deque = new LinkedList<>();
        }

        public void push(int x) {
            while (!deque.isEmpty() && x > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(x);
        }

        public void pop(int x) {
            if (deque.getFirst() == x) {
                deque.removeFirst();
            }
        }

        public int max() {
            return deque.getFirst();
        }
    }
}
