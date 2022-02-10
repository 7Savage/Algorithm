package tree.build;

import tree.TreeNode;

public class InPostBuild {
    //递归
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(postorder, postStart, postStart + (index - inStart - 1) , inorder, inStart, index -1);
        root.right = build(postorder, postStart + (index - inStart), postEnd - 1, inorder, index + 1, inEnd);
        return root;
    }
}
