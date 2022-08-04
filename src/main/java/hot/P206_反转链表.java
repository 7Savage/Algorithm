package hot;

import base.list.ListNode;

public class P206_反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = head;
        ListNode pre = null;
        while (dummy != null) {
            ListNode node = dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = node;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }

        ListNode res = recur(cur.next,cur);
        cur.next = pre;
        return res;
    }
}
