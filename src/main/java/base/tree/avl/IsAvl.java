package base.tree.avl;

import base.tree.TreeNode;

public class IsAvl {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    //后序遍历+剪枝
    //时间复杂度 O(N)
    //空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? (Math.max(left, right) + 1) : -1;
    }
}
