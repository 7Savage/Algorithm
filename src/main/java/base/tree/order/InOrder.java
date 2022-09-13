package base.tree.order;



import swordtooffer.TreeNode;

import java.util.*;

//中序遍历
public class InOrder {
    List<Integer> res = new ArrayList<>();

    //递归

    /**
     * 时间复杂度为O(n)   T(n)=2T(n/2)+1=2(2T(n/4)+1)+1=2^logn+2^(logn-1)+...+2+1 ~= n
     * 所以空间复杂度为O(n)
     * @param t
     */
    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            res.add(t.val);
            inOrder(t.right);
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }


}
