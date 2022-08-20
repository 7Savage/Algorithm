package 笔试.网易;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == nums[i]) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
