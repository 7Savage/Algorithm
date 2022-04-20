package swordtooffer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class P55_II平衡二叉树 {

    //思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
    //时间复杂度 O(N)
    //空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        //剪枝
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        //剪枝
        if (right == -1) {
            return -1;
        }
        //返回深度
        return Math.abs(left - right) < 2 ? (Math.max(left, right) + 1) : -1;
    }
}
