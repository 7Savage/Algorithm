package tree.build;

import tree.TreeNode;

public class MaxBuild {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int index = -1;
        long max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode maxRoot = new TreeNode(max);
        maxRoot.left = build(nums, left, index - 1);
        maxRoot.right = build(nums, index + 1, right);
        return maxRoot;
    }
}
