package swordtooffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class P21_调整数组顺序使奇数位于偶数前面 {
    //时间复杂度 O(N) ： N 为数组 nums 长度，双指针 i, j 共同遍历整个数组。
    //空间复杂度 O(1) ： 双指针 i, j 使用常数大小的额外空间。
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //如果找到奇数就跳过
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            //如果找到偶数就跳过
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            swap(nums, left, right);
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
}
