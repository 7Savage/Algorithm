package hot100;

import swordtooffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P114_二叉树展开为链表 {
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        preorder(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            list.add(root);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
