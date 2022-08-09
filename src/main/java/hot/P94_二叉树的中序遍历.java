package hot;

import swordtooffer.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94_二叉树的中序遍历 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            res.add(root.val);
            dfs(root.right);
        }
    }

    //非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
