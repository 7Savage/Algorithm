package swordtooffer;

import java.util.HashSet;
import java.util.Set;

//输入两个链表，找出它们的第一个公共节点。
public class P52_两个链表的第一个公共节点 {

    //时间复杂度：O(a+b)
    //空间复杂度：O(a+b)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //时间复杂度：O(a+b)
    //空间复杂度：O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = (A != null ? A.next : headB);
            B = (B != null ? B.next : headA);
        }
        return A;
    }
}
