package base.tree.bfs;

import base.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class Serialize {
    // 把一棵二叉树序列化成字符串
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
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
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Long.parseLong(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(split[i])) {
                node.left = new TreeNode(Long.parseLong(split[i]));
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
