package nowcoder.huawei;

import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            if ((i + 1) % 8 == 0) {
                System.out.println();
            }
        }
        int blank = 8 - str.length() % 8;
        if (blank != 8)
            for (int i = 0; i < blank; i++) {
                System.out.print('0');
            }
    }
}
