package hot100;

import swordtooffer.TreeNode;

public class P538_把二叉搜索树转换为累加树 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
