package swordtooffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
public class P57_和为s的两个数字 {
    //和两数之和类似，只不过这题是排序好的
    //时间和空间复杂度均为 O(N)
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if(set.contains(num)){
                return new int[]{num,nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[0];
    }

    //时间复杂度 O(N)： N 为数组 nums 的长度；双指针共同线性遍历整个数组。
    //空间复杂度 O(1) ： 变量 i, j 使用常数大小的额外空间。
    public int[] twoSum2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int s = nums[i] + nums[j];
            if (s == target) {
                return new int[]{nums[i], nums[j]};
            } else if (s > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }
}
