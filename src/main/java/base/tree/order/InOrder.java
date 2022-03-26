package base.tree.order;

import base.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//中序遍历
public class InOrder {
    List<Long> res = new ArrayList<>();

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


    /**
     * 时间复杂度为O(n)
     * 空间复杂度为O(n)
     *
     * @param t
     */
    public void inOrder2(TreeNode t) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.add(t);
                t = t.left;
            } else {
                TreeNode node = stack.pollFirst();
                res.add(node.val);
                t = node.right;
            }
        }
    }


}
