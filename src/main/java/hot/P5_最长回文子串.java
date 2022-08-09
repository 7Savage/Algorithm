package hot;

public class P5_最长回文子串 {
    public String longestPalindrome(String s) {
        String res = new String();
        for (int center = 0; center < s.length() * 2 -1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0&& right < s.length()&& s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > res.length()) {
                    res = s.substring(left, right + 1);
                }
                left --;
                right ++;
            }
        }
        return res;
    }
}
