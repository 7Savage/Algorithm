package 笔试.hulu;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String c = scanner.next();
            String[] strs = scanner.next().split("-");
            StringBuilder sb =new StringBuilder();
            for (int j = 0; j < strs.length; j++) {
                sb.append(strs[i]);
            }
            int date = Integer.parseInt(sb.toString());
            Set<String> set = map.get(date);
            set.add(c);
            map.put(date, set);
        }

        int n = scanner.nextInt();
    }
}
