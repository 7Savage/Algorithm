package nowcoder.huawei;

import java.util.Scanner;

public class HJ13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print(s[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }
}
