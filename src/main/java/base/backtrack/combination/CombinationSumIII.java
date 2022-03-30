package base.backtrack.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 元素不重复不可复选
 */
public class CombinationSumIII {
    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int target;
    int trackSum;

    public List<List<Integer>> combinationSum3(int k, int target) {
        this.target = target;
        backtrack(k, 1);
        return res;
    }

    private void backtrack(int k, int start) {
        if (track.size() > k) {
            return;
        }
        if (trackSum == target && track.size() == k) {
            res.add(new LinkedList<>(track));
        }
        if (trackSum > target) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            track.add(i);
            trackSum += i;
            backtrack(k, i + 1);
            track.removeLast();
            trackSum -= i;
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        combinationSumIII.combinationSum3(3, 7);
    }
}
