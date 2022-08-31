package 笔试.广联达;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] min = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int m = scanner.nextInt();
        int l, r = 0, x;
        for (int i = 0; i < m; i++) {
            l = scanner.nextInt();
            int l2 = l;
            if (l < r) {
                l = r + 1;
            }
            r = scanner.nextInt();
            x = scanner.nextInt();
            for (int j = l2 - 1; j < r; j++) {
                count[j] = 0;
            }
            for (int j = l - 1; j < r; j++) {
                if (min[j] == 0) {
                    min[j] = 1;
                    x--;
                }
                if (x == 0) {
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < min.length; i++) {
            res += min[i];
        }
        for (int i = 0; i < count.length; i++) {
            res += count[i];
        }
        System.out.println(res);
    }
}
