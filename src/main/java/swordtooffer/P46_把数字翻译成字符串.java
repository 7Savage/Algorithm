package swordtooffer;

public class P46_把数字翻译成字符串 {
    public int translateNum(int num) {
        String res = String.valueOf(num);
        int[] dp = new int[res.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= res.length(); i++) {
            String temp = res.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[res.length()];
    }
}
