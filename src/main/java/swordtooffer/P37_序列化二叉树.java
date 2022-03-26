package swordtooffer;

import base.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P37_序列化二叉树 {
    // 把一棵二叉树序列化成字符串
    public String serialize(base.tree.TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<base.tree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            base.tree.TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null").append(",");
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // 把字符串反序列化成二叉树
    public base.tree.TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        base.tree.TreeNode root = new base.tree.TreeNode(Long.parseLong(split[0]));
        Queue<base.tree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            base.tree.TreeNode node = queue.poll();
            if (!"null".equals(split[i])) {
                node.left = new base.tree.TreeNode(Long.parseLong(split[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(split[i])) {
                node.right = new TreeNode(Long.parseLong(split[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
