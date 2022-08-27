package 笔试.ThreeSixZero;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.length() > 10) {
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (!Character.isLetter(s.charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        System.out.println(res);
    }
}
