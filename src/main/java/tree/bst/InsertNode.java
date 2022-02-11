package tree.bst;

import tree.TreeNode;

public class InsertNode {
    //迭代
    public TreeNode insertIntoBST(TreeNode root, long val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        TreeNode node = new TreeNode(val);
        while(true) {
            if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = node;
                    break;
                }else {
                    curr = curr.right;
                }
            } else {
                if (curr.left == null) {
                    curr.left = node;
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }
        return root;
    }

    //递归
    public TreeNode insertIntoBST2(TreeNode root, long val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
