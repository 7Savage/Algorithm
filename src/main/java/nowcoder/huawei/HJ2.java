package nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Character d = Character.toUpperCase(scanner.next().toCharArray()[0]);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                c = Character.toUpperCase(c);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map.get(d) == null ? 0 : map.get(d));
    }
}
