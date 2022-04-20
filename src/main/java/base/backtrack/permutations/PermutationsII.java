package base.backtrack.permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 元素有重不可复选
 */
public class PermutationsII {
    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            //如果访问过就剪枝
            if (used[i]) {
                continue;
            }

            //如果邻近元素相同，并且没有使用过，就剪枝，来保证相同元素之间的相对顺序
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }

    @Test
    public void test(){
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }


}
