package 笔试.BOSS直聘;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        int count = 0;
        while (a >= 10) {
            int x = 1;
            for (int i = 0; i < a.toString().length(); i++) {
                x *= Integer.parseInt(a.toString().substring(i, i + 1));
            }
            a = x;
            count++;
        }
        System.out.println(count);
    }
}
