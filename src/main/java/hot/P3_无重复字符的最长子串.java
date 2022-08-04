package hot;

import java.util.HashMap;
import java.util.Map;

public class P3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                if (map.containsKey(d)) {
                    map.put(d, map.get(d) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
