package 笔试.蔚来;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Double.valueOf(scanner.next());
        }

        double res = 0.0;
        for (int j = 0;j < n;j++) {
            if (nums[j]==1.0 || nums[j]==0.0) {
                res += (double)1.0;
                continue;
            }
            res += nums[j] >= 0.5 ? nums[j]: 1.0 -nums[j];
        }
        System.out.printf("%.4f",res);
    }
}
