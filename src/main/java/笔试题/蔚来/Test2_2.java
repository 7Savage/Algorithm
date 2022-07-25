package 笔试题.蔚来;

import java.util.Scanner;

public class Test2_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = " "+in.next();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = n - k + 1;
        for (int i = k; i < chars.length; i++) {
            sb.append(chars[i]);
        }
//        正序
        if (cnt % 2 == 0) {
            for (int i = 1; i < k; i++) {
                sb.append(chars[i]);
            }
        } else {
            for (int i = k - 1; i > 0; i--) {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());

    }


}
