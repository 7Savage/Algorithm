package swordtooffer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 对称二叉树定义： 对于树中 任意两个对称节点 L 和 R ，一定有：
 * L.val = R.val：即此两对称节点值相等。
 * L.left.val = R.right.val. ：即 L 的 左子节点 和 R 的 右子节点 对称；
 * L.right.val = R.left.val. ：即 L 的 右子节点 和 R 的 左子节点 对称。
 */
public class P28_对称的二叉树 {
    //时间复杂度 O(N)： 其中 N 为二叉树的节点数量,每次执行 recur() 可以判断一对节点是否对称，因此最多调用 N/2 次 recur() 方法。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        //当 L 和 R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true
        if (left == null && right == null) {
            return true;
        }
        //当 L 或 R 中只有一个越过叶节点： 此树不对称，因此返回 false；
        //当节点 L 值 != 节点 R 值： 此树不对称，因此返回 false；
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
