package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        List<Integer> res = new ArrayList<>();
        if (n > m) return res;
        int[] mCnt = new int[26];
        int[] nCnt = new int[26];
        for (int i = 0; i < n; i++) {
            mCnt[s.charAt(i) - 'a']++;
            nCnt[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(mCnt, nCnt)) {
            res.add(0);
        }

        for (int i = n; i < m; i++) {
            mCnt[s.charAt(i) - 'a']++;
            mCnt[s.charAt(i - n) - 'a']--;
            if (Arrays.equals(mCnt, nCnt)) {
                res.add(i - n + 1);
            }
        }
        return res;
    }
}
