package 笔试.小红书;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        long sum = Arrays.stream(a).sum();
        long res = 0;
        if (sum > 0) {
            res += Math.abs(a[n - 1] - 7);
            int i = 0;
            int j = 1;
            while (j < n - 1) {
                int op1 = Math.abs(a[i] + 1) + Math.abs(a[j] + 1);
                int op2 = Math.abs(a[i] - 1) + Math.abs(a[j] - 1);
                res += Math.min(op1, op2);
                i += 2;
                j += 2;
            }
            if ((n - 1) % 2 != 0) {
                res += Math.abs(a[n - 2] - 1);
            }
        } else {
            res += Math.abs(a[0] + 7);
            res += Math.abs(a[1] + 1);
            int i = 2;
            int j = 3;
            while (j < n) {
                int op1 = Math.abs(a[i] + 1) + Math.abs(a[j] + 1);
                int op2 = Math.abs(a[i] - 1) + Math.abs(a[j] - 1);
                res += Math.min(op1, op2);
                i += 2;
                j += 2;
            }
            if (n % 2 != 0) {
                res += Math.abs(a[n - 1] - 1);
            }
        }
        System.out.println(res);

    }
}
