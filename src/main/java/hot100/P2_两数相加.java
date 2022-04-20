package hot100;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

import base.list.ListNode;

public class P2_两数相加 {
    //时间复杂度：O(max(m,n))，其中 m 和 n 分别为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
    //空间复杂度：O(1)。注意返回值不计入空间复杂度。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int remainder = 0;
        int p1, p2;
        while (l1 != null || l2 != null || remainder > 0) {
            p1 = (l1 != null) ? l1.val : 0;
            p2 = (l2 != null) ? l2.val : 0;
            int p = p1 + p2 + remainder;
            remainder = p / 10;
            head.next = new ListNode(p % 10);
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}
