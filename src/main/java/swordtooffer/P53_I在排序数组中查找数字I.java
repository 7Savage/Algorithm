package swordtooffer;

import java.util.HashMap;
import java.util.Map;

//统计一个数字在排序数组中出现的次数。
//注意是一个排序数组
public class P53_I在排序数组中查找数字I {
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        return 0;
    }

    //二分
    //时间复杂度 O(logN) ： 二分法为对数级别复杂度。
    //空间复杂度 O(1) ： 几个变量使用常数大小的额外空间。
    public int search2(int[] nums, int target) {
        return rightBound(nums, target) - leftBound(nums, target) + 1;
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
