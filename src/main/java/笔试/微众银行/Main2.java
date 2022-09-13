package 笔试.微众银行;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            float a = scanner.nextFloat();
            float b = scanner.nextFloat();
            System.out.println(check(a, b));
        }
    }

    public static int check(float a, float b) {
        if (a > b) {
            return check(b, a);
        }

        int ans = 0;
        while (a * 8 <= b) {
            a *= 8;
            ans++;
        }
        while (a * 4 <= b) {
            a *= 4;
            ans++;
        }
        while (a * 2 <= b) {
            a *= 2;
            ans++;
        }
        if (a == b) {
            return ans;
        } else {
            return -1;
        }
    }
}
