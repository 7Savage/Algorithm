package swordtooffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
public class P32_I从上到下打印二叉树 {
    //时间复杂度 O(N)： N 为二叉树的节点数量，即 BFS 需循环 N 次。
    //空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<TreeNode> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i).val;
        }
        return res;
    }
}
