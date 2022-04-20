package hot100;


import swordtooffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P94_二叉树的中序遍历 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }

    public void recur(TreeNode root) {
        if (root != null) {
            recur(root.left);
            res.add(root.val);
            recur(root.right);
        }
    }
}
