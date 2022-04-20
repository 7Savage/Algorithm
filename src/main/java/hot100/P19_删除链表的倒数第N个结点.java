package hot100;

import base.list.ListNode;

public class P19_删除链表的倒数第N个结点 {
    //时间复杂度：O(L)，其中 L 是链表的长度。
    //空间复杂度：O(1)。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 0; i < n - 1; i++) {
            head = head.next;
        }

        ListNode p = dummy;
        while (head.next != null) {
            head = head.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
