package 笔试.广联达;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[i][1] = scanner.nextInt();
        }
        int res = 0;
        int d = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i][1] < nums[i][0]) {
                res++;
                d = Math.max(d, nums[i][0] - nums[i][1]);
            } else if (nums[i][1] - nums[i][0] < res) {
                res++;
            }
        }
        System.out.println(res);
    }
}
