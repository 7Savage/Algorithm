package tree;


import java.util.Deque;
import java.util.LinkedList;

public class InvertTree {
    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //迭代
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;

            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }

            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }
        }
        return root;
    }

}
