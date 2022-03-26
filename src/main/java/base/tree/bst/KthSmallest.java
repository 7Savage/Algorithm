package base.tree.bst;

import base.tree.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 */
public class KthSmallest {
    long res;
    int rank = 0;

    //最坏的时间复杂度是 O(N)
    public long kthSmallest(TreeNode root, int k) {
        preOrder(root, k);
        return res;
    }

    public void preOrder(TreeNode root, int k) {
        if (root != null) {
            preOrder(root.left, k);
            rank++;
            if (rank == k) {
                res = root.val;
                return;
            }
            preOrder(root.right, k);
        }
    }


}
