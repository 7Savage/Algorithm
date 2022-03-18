package nowcoder.huawei;

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int sum = 0;
        int digit = 0;
        for (int i = str.length() - 1; i >= 2; i--) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            }
            if (c >= 'A') {
                digit = c - 'A' + 10;
            }
            sum += digit * (Math.pow(16, str.length() - i - 1));
        }
        System.out.println(sum);
    }
}
