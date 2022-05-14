package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class m5d1_两棵二叉搜索树中的所有元素 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        recur(root1, list1);
        recur(root2, list2);
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            res.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            res.add(list2.get(j));
            j++;
        }
        return res;
    }

    public void recur(TreeNode root, List<Integer> list) {
        if (root != null) {
            recur(root.left, list);
            list.add(root.val);
            recur(root.right, list);
        }
    }
}
