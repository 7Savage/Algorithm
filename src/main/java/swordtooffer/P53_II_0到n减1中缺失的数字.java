package swordtooffer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class P53_II_0到n减1中缺失的数字 {
    //时间复杂度 O(logN)： 二分法为对数级别复杂度。
    //空间复杂度 O(1)： 几个变量使用常数大小的额外空间
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //跳出时，变量 left 和 right 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 left 即可。
        return left;
    }
}
