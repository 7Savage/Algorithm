package swordtooffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class P36_二叉搜索树与双向链表 {
    Node pre, head;

    //时间复杂度 O(N) ： N 为二叉树的节点数，中序遍历需要访问所有节点。
    //空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到 N，系统使用 O(N) 栈空间。
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    //中序遍历
    public void dfs(Node cur) {
        if (cur != null) {
            dfs(cur.left);

            if (pre != null) {
                pre.right = cur;
            } else {
                head = cur;
            }
            cur.left = pre;
            pre = cur;

            dfs(cur.right);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
