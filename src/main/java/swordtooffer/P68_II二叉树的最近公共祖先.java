package swordtooffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P68_II二叉树的最近公共祖先 {

    //记录父亲节点
    Map<TreeNode, TreeNode> map = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();

    //时间复杂度：O(N)
    //空间复杂度：O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }

    //时间复杂度：O(N)
    //空间复杂度：O(N)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


}
