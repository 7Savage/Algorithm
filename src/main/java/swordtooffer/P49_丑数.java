package swordtooffer;

public class P49_丑数 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            int num = Math.min((n2), Math.min(n3, n5));
            dp[i] = num;
            if (num == n2) a++;
            if (num == n3) b++;
            if (num == n5) c++;
        }
        return dp[n - 1];
    }
}
