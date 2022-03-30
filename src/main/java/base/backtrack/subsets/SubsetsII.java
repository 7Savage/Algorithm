package base.backtrack.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 元素有重不可复选
 */
public class SubsetsII {
    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先对数组从小到大排序，使得相同的元素邻近
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            //邻近元素肯定要大于start
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
