package swordtooffer;

import java.util.HashMap;
import java.util.Map;

public class P35_复杂链表的复制 {
    //利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可
    //时间复杂度 O(N) ： 两轮遍历链表，使用 O(N)时间。
    //空间复杂度 O(N) ： 哈希表 dic 使用线性大小的额外空间
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //时间复杂度 O(N)： 三轮遍历链表，使用 O(N) 时间。
    //空间复杂度 O(1) ： 节点引用变量使用常数大小的额外空间。
    public Node copyRandomList2(Node head) {
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3. 拆分两链表
        Node pre = head;
        cur = head.next;
        while (cur.next != null) {
            cur.next = cur.next.next;
            pre.next = pre.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        // 该步多余，只是为了将两条链表完全分开
        // pre.next = null;
        return head.next;
    }
}
