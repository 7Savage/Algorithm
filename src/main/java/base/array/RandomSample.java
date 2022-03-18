package base.array;

import base.list.ListNode;

import java.util.Random;

public class RandomSample {
    ListNode node;
    Random random;

    /**
     * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
     * <p>
     * 实现 Solution 类：
     * <p>
     * Solution(ListNode head) 使用整数数组初始化对象。
     * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
     *
     * @param head
     */
    public RandomSample(ListNode head) {
        this.node = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode p = node;
        int res = 0;
        int i = 0;
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (0 == random.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
