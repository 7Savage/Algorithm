package hot;

public class P647_回文子串 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int center = 0; center < s.length() * 2 - 1; center ++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right ++;
                res ++;
            }
        }
        return res;
    }
}
