package swordtooffer;

//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
public class P54_二叉搜索树的第k大节点 {
    int rank = 0;
    int res;

    //时间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 N ，占用 O(N) 时间。
    //空间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），系统使用 O(N) 大小的栈空间。
    public int kthLargest(TreeNode root, int k) {
        recur(root, k);
        return res;
    }

    public void recur(TreeNode root, int k) {
        if (root != null) {
            recur(root.right, k);

            rank++;
            if (rank == k) {
                res = root.val;
                return;
            }
            recur(root.left, k);
        }
    }
}
