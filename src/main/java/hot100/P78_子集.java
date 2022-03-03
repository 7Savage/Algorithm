package hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P78_子集 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> set = new ArrayDeque<>();
        dfs(nums, 0, set);
        return res;
    }

    private void dfs(int[] nums, int begin, Deque<Integer> set) {
        res.add(new ArrayList<>(set));
        for (int i = begin; i < nums.length; i++) {
            set.addLast(nums[i]);
            dfs(nums, i + 1, set);
            set.removeLast();
        }
    }
}
