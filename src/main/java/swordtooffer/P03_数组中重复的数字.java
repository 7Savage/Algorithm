package swordtooffer;

import java.util.HashSet;
import java.util.Set;
/*
    找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。
    */
public class P03_数组中重复的数字 {

    /*
    暴力、哈希表
    时间复杂度：O(n)：遍历数组一遍。使用哈希集合（HashSet），添加元素的时间复杂度为 O(1)，故总的时间复杂度是 O(n)。
    空间复杂度：O(n)：不重复的每个元素都可能存入集合，因此占用 O(n)额外空间。
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    /*
    原地置换
    时间复杂度 O(N)：遍历数组使用 O(N)，每轮遍历的判断和交换操作使用 O(1) 。
    空间复杂度 O(1)：使用常数复杂度的额外空间。
     */
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            } else if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
