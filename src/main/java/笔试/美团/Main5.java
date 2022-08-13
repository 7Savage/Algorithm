package 笔试.美团;

import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        TreeNode root = buildTree(0, nums);
        System.out.println(dfs(root));
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int curMaxSum = Math.max(Math.max(leftSum, rightSum), 0) + root.val;
        return curMaxSum;
    }

    //数组建树
    public static TreeNode buildTree(int index, int[] values) {
        if (index >= values.length) {
            return null;
        }
        int value = values[index];

        TreeNode root = new TreeNode(value);
        root.left = buildTree(2 * index + 1, values);
        root.right = buildTree(2 * index + 2, values);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
