package base.tree.build;


import base.tree.TreeNode;

public class ArrayToTree {
    //数组建树
    public TreeNode buildTree(int index, String[] values) {
        if (index >= values.length) {
            return null;
        }
        String value = values[index];
        if (value.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Long.parseLong(value));
        root.left = buildTree(2 * index + 1, values);
        root.right = buildTree(2 * index + 2, values);
        return root;
    }
}
