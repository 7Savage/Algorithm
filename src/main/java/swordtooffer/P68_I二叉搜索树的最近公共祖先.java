package swordtooffer;

public class P68_I二叉搜索树的最近公共祖先 {

    /**
     * 迭代
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 NlogN （满二叉树），最大为 N （退化为链表）。
        //空间复杂度 O(1) ： 使用常数大小的额外空间。
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null) {
            if (root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    //时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为  NlogN （满二叉树），最大为 NN （退化为链表）。
    //空间复杂度 O(N) ： 最差情况下，即树退化为链表时，递归深度达到树的层数 N 。
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);//当 p, q 都在 root 的 右子树 中，则开启递归 root.right 并返回
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);//当 p, q 都在 root 的 左子树 中，则开启递归 root.left 并返回
        }
        return root;
    }

}
