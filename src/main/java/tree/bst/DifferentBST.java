package tree.bst;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class DifferentBST {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int low, int high) {
        if (low > high) {
            return 1;
        }
        if (memo[low][high] != 0) {
            return memo[low][high];
        }

        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);
            for (TreeNode left :
                    leftTree) {
                for (TreeNode right :
                        rightTree) {
                    TreeNode root = new TreeNode((long) i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }


}
