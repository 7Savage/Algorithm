package nowcoder.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
