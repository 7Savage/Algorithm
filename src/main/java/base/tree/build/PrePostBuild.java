package base.tree.build;

import swordtooffer.TreeNode;

import java.util.HashMap;
import java.util.Map;

//只有每个节点度为2或者0的时候前序和后序才能唯一确定一颗二叉树，只有一个子节点是无法确定的，因为你无法判断他是左子树还是右子树
public class PrePostBuild {
    //1、首先把前序遍历结果的第一个元素或者后序遍历结果的最后一个元素确定为根节点的值。
    //2、然后把前序遍历结果的第二个元素作为左子树的根节点的值。
    //3、在后序遍历结果中寻找左子树根节点的值，从而确定了左子树的索引边界，进而确定右子树的索引边界，递归构造左右子树即可。

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 数组中只有一个元素时，直接构建出这个节点。
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];

        int index = -1;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == leftRootVal) {
                index = i;
                break;
            }
        }
        root.left = build(preorder, preStart + 1, preStart + (index - postStart + 1), postorder, postStart, index);
        root.right = build(preorder, preStart + (index - postStart + 2), preEnd, postorder, index + 1, postEnd-1);
        return root;
    }
}
