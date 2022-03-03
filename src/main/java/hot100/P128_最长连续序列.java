package hot100;

import java.util.HashSet;

public class P128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = 0;
                while (set.contains(num)) {
                    num++;
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
