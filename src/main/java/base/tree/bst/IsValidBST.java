package base.tree.bst;

import base.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST {

    //递归
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    //中序迭代
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long inorder = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pollLast();
                if (node.val <= inorder) {
                    return false;
                }
                inorder = node.val;
                root = node.right;
            }
        }
        return true;
    }
}
