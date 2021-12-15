package list.mergeLists;



import list.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        Queue<ListNode> priorityQueue = new PriorityQueue<>();
        for (ListNode node :
                lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null) {
                node = node.next;
                priorityQueue.add(node);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
