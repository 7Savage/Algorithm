package 笔试.志杰;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }

            Arrays.sort(a);
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (threeSum(Arrays.copyOf(a, a.length), a[j])) {
                    System.out.println("YES");
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("NO");
        }
    }

    public static boolean threeSum(int[] nums, int target) {

        int n = nums.length;

        for (int k = 0; k < n - 2; k++) {
            int i = k + 1;
            int j = n - 1;
            Arrays.sort(nums, i, j);
            while (i < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    while (i < j && nums[i] == nums[++i]) ;
                }
            }
        }
        return false;
    }
}
