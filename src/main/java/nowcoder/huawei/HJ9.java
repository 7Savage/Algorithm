package nowcoder.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Set<Character> set = new HashSet<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!set.contains(str.charAt(i))) {
                System.out.print(str.charAt(i));
            }
            set.add(str.charAt(i));
        }

    }
}
