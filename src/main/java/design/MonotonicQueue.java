package design;

import java.util.*;

//单调队列
public class MonotonicQueue {
    Deque<Integer> queue;

    public MonotonicQueue() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        while (!queue.isEmpty() && x > queue.getLast()) {
            queue.removeLast();
        }
        queue.addLast(x);
    }

    public void pop(int x) {
        //如果队首的元素不是最大值，说明在push阶段已经被移除了
        if (x == queue.getFirst()) {
            queue.removeFirst();
        }
    }

    public int max() {
        return queue.getFirst();
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                list.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
