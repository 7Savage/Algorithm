package hot100;

import swordtooffer.TreeNode;

public class P543_二叉树的直径 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int L = dfs(root.left);
        int R = dfs(root.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
