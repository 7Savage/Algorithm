package base.tree.build;

import base.tree.TreeNode;

public class PreInBuild {

    //递归
    //时间复杂度：O(n)，其中 n 是树中的节点个数。
    //空间复杂度：O(n)，除去返回的答案需要的 O(n)空间之外，我们还需要使用 O(n) 的空间存储哈希映射，以及 O(h)（其中 h 是树的高度）的空间表示递归时栈空间。这里 h < n，所以总空间复杂度为 O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * @param preorder 前序遍历数组
     * @param preStart
     * @param preEnd
     * @param inorder  中序遍历数组
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        long rootVal = preorder[preStart];
        int index = -1;
        // rootVal 在中序遍历数组中的索引
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + (index - inStart), inorder, inStart, index - 1);
        root.right = build(preorder, preStart + (index - inStart + 1), preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
