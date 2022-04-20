package swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
// 叶子节点 是指没有子节点的节点。
public class P34_二叉树中和为某一值的路径 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int preSum = 0;

    //时间复杂度 O(N) ： N 为二叉树的节点数，先序遍历需要遍历所有节点。
    //空间复杂度 O(N)： 最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N)额外空间。
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        preSum += root.val;
        track.add(root.val);
        //确保是根节点到叶子节点
        if (preSum == target && root.left == null && root.right == null) {
            res.add(new LinkedList<>(track));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        track.removeLast();
        preSum -= root.val;
    }
}
