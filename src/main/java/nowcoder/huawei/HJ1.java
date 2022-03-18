package nowcoder.huawei;

import java.util.Scanner;

public class HJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }
        System.out.println(length);
    }
}
