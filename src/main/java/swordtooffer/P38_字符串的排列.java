package swordtooffer;

import org.junit.Test;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 元素有重不可复选
 */
public class P38_字符串的排列 {
    List<String> res = new ArrayList<>();
    boolean[] used;
    StringBuilder track = new StringBuilder();

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        //一定要进行排序，使得相邻元素靠近
        Arrays.sort(chars);
        dfs(chars, used);
        //集合转字符串
        return res.toArray(new String[0]);
    }

    public void dfs(char[] chars, boolean[] used) {
        if (track.length() == chars.length) {
            res.add(new String(track));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            //如果访问过就剪枝
            if (used[i]) {
                continue;
            }
            //如果邻近元素相同，并且没有使用过，就剪枝，来保证相同元素之间的相对顺序
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            track.append(chars[i]);
            used[i] = true;
            dfs(chars, used);
            track.setLength(track.length() - 1);
            used[i] = false;
        }
    }

    @Test
    public void test() {
        String[] strs = permutation("aab");
        System.out.println(Arrays.toString(strs));
    }
}
