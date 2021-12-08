package tree;

public class PreOrder {

    //递归
    public void preOrder(TreeNode t) {
        if (t != null) {
            System.out.println(t.val);
            preOrder(t.left);
            preOrder(t.right);
        }
    }
}
