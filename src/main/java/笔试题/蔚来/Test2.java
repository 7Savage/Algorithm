package 笔试题.蔚来;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String S = scanner.next();
        for (int i = K - 1; i < N; i++) {
            String head = S.substring(0, i - K + 1);
            String body = new StringBuilder(S.substring(i - K + 1, i + 1)).reverse().toString();
            String tail = S.substring(i + 1, N);
            S = head + body + tail;
        }
        System.out.println(S);
    }
}
