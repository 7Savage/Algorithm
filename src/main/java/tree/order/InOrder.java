package tree.order;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//中序遍历
public class InOrder {
    List<Long> res = new ArrayList<>();

    //递归
    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            res.add(t.val);
            inOrder(t.right);
        }
    }


    //迭代
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
