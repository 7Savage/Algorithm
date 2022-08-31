package 笔试.顺丰;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n - 1];
        int[] a = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = scanner.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

    }
}
