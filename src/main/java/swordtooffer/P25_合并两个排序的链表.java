package swordtooffer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class P25_合并两个排序的链表 {
    //时间复杂度 O(M+N) ： M, N分别为两个链表的长度，合并操作需遍历两链表。
    //空间复杂度 O(1)： 节点引用 dumdum , curcur 使用常数大小的额外空间。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;

    }
}
