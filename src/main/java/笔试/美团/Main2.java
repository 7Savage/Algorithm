package 笔试.美团;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k =scanner.nextInt();
        boolean[][] flag = new boolean[n][m];
        int cnt = 0;
        int x = 0;
        int y = 0;
        char[] chars = scanner.next().toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'W') {
                x += dx[0];
                y += dy[0];
            } else if (chars[i] == 'A') {
                x += dx[1];
                y += dy[1];
            } else if (chars[i] == 'S') {
                x += dx[2];
                y += dy[2];
            } else {
                x += dx[3];
                y += dy[3];
            }

            if (!flag[x][y]) {
                cnt++;
            }
            flag[x][y] = true;
            if (cnt == n * m) {
                ans = i;
                break;
            }
        }

        if (ans != 0) {
            System.out.println("Yes");
            System.out.println(ans);
        } else {
            System.out.println("No");
            System.out.println(n * m - cnt);
        }
    }
}
