package 笔试.拼多多;

import java.io.*;


public class Main2 {
    static int[] w, cnt;
    static boolean[] turn, flag;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(scanner.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(scanner.readLine());
            w = new int[n + 1];
            turn = new boolean[n + 1];
            flag = new boolean[n + 1];
            cnt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                String[] split = scanner.readLine().split(" ");
                turn[i] = split[0].equals("L");
                w[i] = Integer.parseInt(split[1]);
            }
            for (int i = 1; i <= n; i++) {
                if (!flag[i]) {
                    cnt[i] = dfs(i, 0);
                }
            }

            for (int i = 1; i < cnt.length; i++) {
                if (i== cnt.length-1){
                    out.write(cnt[i]);
                }else{
                    out.write(cnt[i] + " ");
                }
            }
            out.write("\n");

        }
        out.flush();
    }

    private static int dfs(int u, int step) {
        if (flag[u]) {
            if (cnt[u] <= 0) {
                cnt[u] = -1;
                return -1;
            }
            return cnt[u] + step;
        }
        flag[u] = true;
        if (check(u)) {
            cnt[u] = step + 1;
            return step + 1;
        } else {
            if (turn[u]) {
                cnt[u] = dfs(u - w[u], step + 1);
            } else {
                cnt[u] = dfs(u + w[u], step + 1);
            }
            return cnt[u];
        }
    }

    private static boolean check(int i) {
        boolean t = turn[i];
        int x = w[i];
        if (t) {
            return i - x < 1;
        } else {
            return i + x > n;
        }
    }
}
