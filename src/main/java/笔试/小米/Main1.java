package 笔试.小米;

import base.list.ListNode;

public class Main1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
            q = q.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode node = q.next;
            q.next = q.next.next;
            node.next = p.next;
            p.next = node;
        }
        return dummy.next;

    }
}
