package tree;

public class InOrder {
    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            System.out.println(t.val);
            inOrder(t.right);
        }
    }


}
