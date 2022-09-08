package 笔试.腾讯音乐;

import swordtooffer.TreeNode;

public class Main3 {
    int mod = (int) (1e9 + 7);

    public int getTreeSum(TreeNode tree) {
        int left = -1;
        int right = -1;
        if (tree.left != null) {
            left = getTreeSum(tree.left);
        }
        if (tree.right != null) {
            right = getTreeSum(tree.right);
        }
        if (left + right <= -2) {
            return Math.max(tree.val, 1) % mod;
        } else if (left == -1 || right == -1) {
            return Math.max(tree.val, 1) + Math.max(left, right) % mod;
        } else {
            return Math.max(tree.val, 1) + Math.max(left, right) * 2 % mod;
        }

    }
}
