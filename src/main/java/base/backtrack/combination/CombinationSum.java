package base.backtrack.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 元素无重可复选
 */
public class CombinationSum {
    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int trackSum = 0;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        backtrack(candidates, 0);
        return res;
    }

    public void backtrack(int[] candidate, int start) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < candidate.length; i++) {
            track.add(candidate[i]);
            trackSum += candidate[i];
            backtrack(candidate, i);
            track.removeLast();
            trackSum -= candidate[i];
        }
    }
}
