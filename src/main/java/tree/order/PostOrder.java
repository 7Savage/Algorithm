package tree.order;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrder {
    //递归
    public void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.println(t.val);
        }
    }

    //迭代
    public List<Long> postOrder2(TreeNode root) {
        List<Long> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.add(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pollLast();
            stack2.add(node);
            if (node.left != null) {
                stack1.add(node.left);
            }
            if (node.right != null) {
                stack1.add(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pollLast().val);
        }
        return res;
    }
}
