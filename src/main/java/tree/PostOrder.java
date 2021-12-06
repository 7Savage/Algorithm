package tree;

public class PostOrder {
    public void postOrder(TreeNode t) {
        if (t != null) {
            postOrder(t.left);
            postOrder(t.right);
            System.out.println(t.val);
        }
    }
}
