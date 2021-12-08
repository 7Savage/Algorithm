package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrder {
    List<Integer> res = new ArrayList<>();

    //递归
    public void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            res.add(t.val);
            inOrder(t.right);
        }
    }


    public void inOrder2(TreeNode t) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.add(t);
                t = t.left;
            } else {
                TreeNode node = stack.pollLast();
                res.add(node.val);
                t = node.right;
            }
        }
    }


}
