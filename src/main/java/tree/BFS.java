package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFS {
    public void levelOrder(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            System.out.println(node.val);
            if (node.left != null) {
                level.add(node.left.val);
            }
            if (node.right != null) {
                level.add(node.right.val);
            }
        }

    }
}
