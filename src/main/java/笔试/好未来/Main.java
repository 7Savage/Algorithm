package 笔试.好未来;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.next().split(",");
        int k = scanner.nextInt();
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        for (String s : str) {
            head.next = new ListNode(Integer.parseInt(s));
            head = head.next;
        }
        head = dummy.next;
        head = reverseKGroup(head, k);
        while (head.next != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.print(head.val);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
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

    public static ListNode reverse(ListNode a, ListNode b) {
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

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
}
