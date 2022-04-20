package 笔试题.Day0402_京东.code;

import java.math.BigInteger;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//行走次数
        BigInteger X = new BigInteger(scanner.next());
        BigInteger num2 = new BigInteger("2");
        BigInteger num1 = new BigInteger("1");
        char[] track = scanner.next().toCharArray();
        for (int i = 0; i < track.length; i++) {
            if (track[i] == 'U') {
                X = X.divide(num2);
            } else if (track[i] == 'R') {
                X = X.multiply(num2).add(num1);
            } else {
                X = X.multiply(num2);
            }
        }
        System.out.println(X);
    }
}
