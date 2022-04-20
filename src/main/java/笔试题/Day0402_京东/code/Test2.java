package 笔试题.Day0402_京东.code;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            char[] chars = scanner.next().toCharArray();
            int[] num = new int[3];
            for (char c : chars) {
                num[c - 'A']++;
            }
            int avg = Arrays.stream(num).sum();
            int count=0;
            for (char c : chars) {
                if (num[c - 'A'] < avg) {
                    continue;
                }

            }
            System.out.println(count);
        }
    }
}
