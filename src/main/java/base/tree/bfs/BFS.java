package base.tree.bfs;

import base.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFS {
    /**
     * 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
     * 空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)。
     * @param root
     */
    public void levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //求深度的时候需要用的for循环
    public List<List<Long>> levelOrder2(TreeNode root) {
        List<List<Long>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        int depth = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Long> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            depth++;
        }
        return res;
    }
}
