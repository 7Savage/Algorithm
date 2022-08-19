package base.dp.子序列;

public class P1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= col; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[row][col];
    }
}
