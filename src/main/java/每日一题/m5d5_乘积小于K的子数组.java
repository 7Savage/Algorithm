package 每日一题;

public class m5d5_乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        int temp = 1;

        while (right < nums.length) {
            temp *= nums[right];
            while (temp >= k) {
                temp /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
