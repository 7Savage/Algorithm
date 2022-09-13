package 笔试.微众银行;

import java.util.Scanner;

public class Main3 {
    static int MOD = 998244353;
    static int N = 1010;
    static int M = 15;
    static int m, n;
    static long[][][][] dp = new long[N][M][M][M];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        dp[0][m + 1][m + 1][m + 1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= m + 1; a++) {
                for (int b = 1; b <= m + 1; b++) {
                    for (int c = 1; c <= m + 1; c++) {
                        for (int x = 1; x <= a && x <= m; x++) {
                            dp[i][x][b][c] = (dp[i][x][b][c] + dp[i - 1][a][b][c]) % MOD;
                        }
                        for (int x = a + 1; x <= b && x <= m; x++) {
                            dp[i][a][x][c] = (dp[i][a][x][c] + dp[i - 1][a][b][c]) % MOD;
                        }
                        for (int x = b + 1; x <= c && x <= m; x++) {
                            dp[i][a][b][x] = (dp[i][a][b][x] + dp[i - 1][a][b][c]) % MOD;
                        }
                    }
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    res = (res + dp[n][i][j][k]) % MOD;
                }
            }
        }
        System.out.println(res);
    }


}
