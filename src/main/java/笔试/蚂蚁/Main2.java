package 笔试.蚂蚁;

import java.util.*;

public class Main2 {
    static long res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if (v < u) {
                int temp = u;
                u = v;
                v = temp;
            }
            Set<Integer> s = map.getOrDefault(u, new HashSet<>());
            s.add(v);
            map.put(u, s);
        }
        dfs(1, 1, map, new boolean[n + 1]);
        System.out.println(res);

    }

    public static void dfs(int u, int q, Map<Integer, Set<Integer>> map, boolean[] visited) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        res += u - q;
        for (int v : map.getOrDefault(u, new HashSet<>())) {
            dfs(v, u, map, visited);
        }
    }


}
