package base.tree;

//求一棵二叉树的最大值
public class MaxVal {
    int maxVal(TreeNode root) {
        if (root == null)
            return -1;
        int left = maxVal(root.left);
        int right = maxVal(root.right);
        return max(root.val, left, right);
    }

    public int max(long a, long b, long c) {
        return (int) Math.max(a, Math.max(b, c));
    }
}
