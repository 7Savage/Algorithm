package swordtooffer;


import java.util.HashMap;
import java.util.Map;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
public class P48_最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int temp = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            temp = (j - i) > temp ? temp + 1 : j - i;
            res = Math.max(temp, res);
        }
        return res;
    }
}
