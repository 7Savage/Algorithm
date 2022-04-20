package swordtooffer;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class P27_二叉树的镜像 {
    //时间复杂度 O(N) ： 其中 N 为二叉树的节点数量
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
