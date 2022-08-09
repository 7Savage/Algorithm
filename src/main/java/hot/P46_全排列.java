package hot;

import java.util.LinkedList;
import java.util.List;

public class P46_全排列 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, visited);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new LinkedList(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited);
            list.removeLast();
            visited[i] = false;
        }
    }
}
