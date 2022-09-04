package 笔试.Test;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nums[i] = num;
            max = Math.max(max, num);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (max != nums[i]) {
                res++;
            }
        }
        System.out.println(res);

    }
}
