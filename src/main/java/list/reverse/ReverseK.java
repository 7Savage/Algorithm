package list.reverse;

import list.ListNode;

public class ReverseK {
    //递归+迭代
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newNode = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newNode;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode curr = a;
        ListNode prev = null;
        ListNode nxt = null;
        while (curr != b) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
