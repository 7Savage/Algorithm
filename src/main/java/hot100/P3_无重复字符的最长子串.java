package hot100;

import java.util.HashMap;
import java.util.HashSet;

public class P3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < chars.length) {
            char c = chars[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = chars[left];
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, (right - left));
        }
        return res;
    }
}
