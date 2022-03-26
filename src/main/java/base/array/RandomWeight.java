package base.array;

import java.util.Random;

/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * <p>
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * <p>
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 */
public class RandomWeight {
    int[] nums;
    Random random;


    public RandomWeight(int[] w) {
        random = new Random();
        int n = w.length;
        nums = new int[n + 1];
        nums[0] = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = w[i - 1] + nums[i - 1];
        }
    }

    public int pickIndex() {
        int n = nums.length;
        //nextInt(bound)区间是 [0,bound)+1 -> [1,bound]
        int target = random.nextInt(nums[n - 1]) + 1;
        // 获取 target 在前缀和数组 sum 中的索引
        // 别忘了前缀和数组 sum 和原始数组 w 有一位索引偏移
        return leftBound(nums, target) - 1;
    }

    /**
     * 当目标元素 target 不存在数组 nums 中时, 返回的这个值是 nums 中大于等于 target 的最小元素索引
     * @param nums
     * @param target
     * @return
     */
    private int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
