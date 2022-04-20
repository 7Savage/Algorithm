package swordtooffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class P07_重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int index = -1;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        root.left = build(preorder, preStart+1, preStart + (index - inStart), inorder, inStart, index - 1);
        root.right = build(preorder, preStart + (index - inStart + 1), preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
