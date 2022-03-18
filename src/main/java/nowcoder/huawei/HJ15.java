package nowcoder.huawei;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        while (num != 0) {
            int c = num % 2;
            if (c == 1) {
                count++;
            }
            num = num / 2;
        }
        System.out.println(count);
    }
}
