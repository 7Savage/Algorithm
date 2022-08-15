package 笔试.民生科技;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String str = scanner.next();
        int i = 0;
        int res = 0;
        int count = 0;
        while (i < str.length() - 1) {
            while (i < str.length() - 1 && str.charAt(i) != '(') {
                i++;
            }
            count = 1;
            int j = i + 1;
            int tmp = 0;
            while (j < str.length()) {
                if (str.charAt(j) == '(') {
                    count++;
                }
                if (str.charAt(j) == ')') {
                    tmp += count;
                }
                if (tmp >= k) {
                    res++;
                }
                j++;
            }
            i++;
        }
        System.out.println(res);
    }
}
