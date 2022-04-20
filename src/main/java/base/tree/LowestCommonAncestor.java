package base.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestor {
    //记录父亲节点的map
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    //用于判断节点是否访问过的集合
    Set<TreeNode> visited = new HashSet<>();

    //时间复杂度：O(N)
    //空间复杂度：O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p);
            p = parent.get(p);//变成父节点
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parent.get(q);//变成父节点
        }
        return null;
    }

    //构建回溯到父亲节点的map
    public void dfs(TreeNode p) {
        if (p.left != null) {
            parent.put(p.left, p);
            dfs(p.left);
        }
        if (p.right != null) {
            parent.put(p.right, p);
            dfs(p.right);
        }
    }
}
