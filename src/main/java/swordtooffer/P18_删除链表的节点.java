package swordtooffer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 */
public class P18_删除链表的节点 {
    //时间复杂度: O(n)
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode dummy = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (dummy != null) {
            if (dummy.val == val) {
                pre.next = dummy.next;
                break;
            }
            pre = dummy;
            dummy = dummy.next;
        }
        return head;
    }
}
