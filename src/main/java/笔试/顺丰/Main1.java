package 笔试.顺丰;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long res = 0;
        while (n > 1) {
            res += Math.ceil(Math.log(n + 1)/Math.log(2));
            n--;
        }
        System.out.println(res + 1);
    }
}
