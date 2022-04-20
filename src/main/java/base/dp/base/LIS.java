package base.dp.base;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LIS {
    //时间复杂度 O(N^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // 寻找 nums[0..i-1] 中比 nums[i] 小的元素
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //二分搜索，时间复杂度 O(NlogN)
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;//堆的个数
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int target = nums[i];
            int left = 0;
            int right = piles - 1;
            //搜索左侧边界的二分查找，找到第一个比target大的
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > target) {
                    right = mid - 1;
                } else if (top[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }
            // 把这张牌放到牌堆顶
            top[left] = target;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
