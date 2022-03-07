package base.design;

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

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
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
