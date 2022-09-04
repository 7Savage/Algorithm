package 笔试.小红书;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] A = new int[n * 2];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int j = 1;
        for (int i = n; i < 2 * n; i++) {
            A[i] = A[n - j];
            j++;
        }
        int temp = k % (2 * n);
        System.out.println(A[temp - 1]);
    }
}
