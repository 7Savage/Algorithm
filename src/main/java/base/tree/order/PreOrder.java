package base.tree.order;



import swordtooffer.TreeNode;

import java.util.*;

public class PreOrder {

    //递归
    public void preOrder(TreeNode t) {
        if (t != null) {
            System.out.println(t.val);
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
        return res;
    }
}
