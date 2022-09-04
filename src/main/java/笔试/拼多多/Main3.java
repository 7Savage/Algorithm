package 笔试.拼多多;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        String T = scanner.next();
        int count = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                count++;
                continue;
            }
            if (need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (char c :
                need.keySet()) {
            int v = need.get(c);
            if (map.get(c) > v) {
                map.put(c, map.get(c) - v);
            }
        }
        System.out.println(S);
    }
}
