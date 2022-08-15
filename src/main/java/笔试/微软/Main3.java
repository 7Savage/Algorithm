package 笔试.微软;

public class Main3 {
    public static int solution(int[] A, int X, int Y) {
        int N = A.length;
        int[][] dp = new int[N][X + 1];
        dp[0][X - 1] = A[0];
        for (int j = X - 2; j >= 0; j--) {
            dp[0][j] = 2 ^ 16;
        }
        for (int i = 1; i < N; i++) {
            for (int j = X; j >= 0; j--) {
                if (i - Y < 0 || j + 1 > X) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - Y][j + 1] + A[i], dp[i - 1][j]);
                }
            }
        }
        return dp[N - 1][0];
    }



    public int solution2(int[] A, int X, int Y) {
        int n = A.length;
        int[] cnt = new int[Y];
        int res = (int)1e9;
        for (int start = 0; start < Y; start++) {
            if (start + (X - 1) * Y >= n)
                break;

            for (int i = 0; i < X; i++) {
                cnt[start] += A[start + i * Y];
            }
            res = Math.min(res, cnt[start]);
            for (int begin = start; begin + X * Y < n; begin += Y) {
                cnt[start] -= A[begin];
                cnt[start] += A[begin + X * Y];
                res = Math.min(res, cnt[start]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 4, 3, 5, 1, 4, 2, 7};
        int X = 3, Y = 2;
        System.out.println(solution(A, X, Y));
    }
}
