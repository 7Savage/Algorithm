package nowcoder.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map.size());
    }
}
