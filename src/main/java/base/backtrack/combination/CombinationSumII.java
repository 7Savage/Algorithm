package base.backtrack.combination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合
 *
 * 元素有重不可复选
 */
public class CombinationSumII {
    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int trackSum;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        //先排序，使得相同元素邻近
        Arrays.sort(candidates);
        backtrack(candidates, 0);
        return res;
    }

    public void backtrack(int[] candidates, int start) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //相同元素就剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            track.add(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i + 1);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
