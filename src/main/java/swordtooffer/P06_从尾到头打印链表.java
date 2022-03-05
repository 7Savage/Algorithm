package swordtooffer;

import base.list.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class P06_从尾到头打印链表 {
    List<Integer> list = new ArrayList<>();

    /**
     * 递归
     * 时间复杂度 O(N)： 遍历链表，递归 N 次。
     * 空间复杂度 O(N)： 系统递归需要使用 O(N) 的栈空间
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        reverse(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void reverse(ListNode head) {
        if (head.next != null) {
            reverse(head.next);
        }
        list.add(head.val);
    }

    /**
     * 辅助栈
     * 时间复杂度 O(N)： 入栈和出栈共使用 O(N) 时间。
     * 空间复杂度 O(N)： 辅助栈 stack 和数组 res 共使用 O(N) 的额外空间
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
