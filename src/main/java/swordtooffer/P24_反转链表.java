package swordtooffer;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
public class P24_反转链表 {

    //递归
    //时间复杂度 O(N)： 遍历链表使用线性大小时间。
    //空间复杂度 O(N)： 遍历链表的递归深度达到 N ，系统使用 O(N)大小额外空间。
    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        //返回尾结点后，res一直就没有变
        ListNode res = recur(cur.next, cur);
        //反转
        cur.next = pre;
        //尾结点
        return res;
    }

    //迭代：用伪节点
    //时间复杂度 O(N)： 遍历链表使用线性大小时间。
    //空间复杂度 O(1)： 变量 pre 和 cur 使用常数大小额外空间。
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode dummy = head;
        while (dummy != null) {
            ListNode next = dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = next;
        }
        return pre;
    }
}
