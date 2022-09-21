package 笔试.蚂蚁;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        StringBuilder res = new StringBuilder();
        while (x > 0) {
            int cur = x;
            int t = x & (x - 1);
            t = cur - t;
            x = x & (x - 1);
            char c = (char) ('a' + Math.log(t) / Math.log(2));
            res.append(c);
        }
        System.out.println(res);
    }
}
