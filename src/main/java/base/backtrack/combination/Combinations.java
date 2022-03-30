package base.backtrack.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 *
 * 元素无重不可复选
 */
public class Combinations {
    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }

    public void backtrack(int n, int start, int k) {
        //返回集合大小为k的链表
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, i + 1, k);
            track.removeLast();
        }
    }
}
