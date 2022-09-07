package 笔试.去哪儿;

public class Main1 {
    public int maxScore(int energy, int[][] actions) {
        int n = actions.length;
        int[][] dp = new int[n + 1][energy + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= energy; j++) {
                if (j - actions[i - 1][0] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - actions[i - 1][0]] + actions[i - 1][1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][energy];
    }
}
