package base.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class CountNodes {
    //假如是一个普通二叉树
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    //假如是一个满二叉树
    public int countNodes2(TreeNode root) {

        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return (int) Math.pow(2, height) - 1;
    }

    //满二叉树相当于普通二叉树和满二叉树的结合
    //算法的递归深度就是树的高度 O(logN)，每次递归所花费的时间就是 while 循环，需要 O(logN)，所以总体的时间复杂度是 O(logN*logN)
    public int countNodes3(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;
        int lh = 0;//左子树高度
        int rh = 0;//右子树高度
        while (l != null) {
            l = l.left;
            lh++;
        }
        while (r != null) {
            r = r.right;
            rh++;
        }
        //高度相同就按满二叉树计算
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }
        //高度不相同就按普通二叉树计算
        return 1 + countNodes3(root.left) + countNodes3(root.right);
    }


}
