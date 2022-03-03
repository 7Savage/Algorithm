package base.tree.bst;

import base.tree.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {

        while (true) {
            if (root == null) {
                return null;
            }
            if (val == root.val) {
                return root;
            }else if (val < root.val) {
                root = root.left;
            }else {
                root = root.right;
            }
        }
    }
}
