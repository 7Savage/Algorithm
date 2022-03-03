package base.tree.build;

import base.tree.TreeNode;

public class PreInBuild {

    //递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        long rootVal = preorder[preStart];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + (index - inStart), inorder, inStart, index - 1);
        root.right = build(preorder, preStart + (index - inStart + 1), preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
