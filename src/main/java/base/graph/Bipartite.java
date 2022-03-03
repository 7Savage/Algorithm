package base.graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Bipartite {

    boolean[] visited;
    boolean[] color;
    boolean ok = true;

    //DFS判断二分图
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    private void traverse(int[][] graph, int v) {
        if (!ok) {
            return;
        }
        visited[v] = true;
        for (int next :
                graph[v]) {
            if (!visited[next]) {
                color[next] = !color[v];
                traverse(graph, next);
            } else {
                if (color[next] == color[v]) {
                    ok = false;
                }
            }
        }
    }

    //BFS判断二分图
    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse2(graph, v);
            }
        }
        return ok;
    }

    private void traverse2(int[][] graph, int start) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            Integer v = deque.pollLast();
            for (int next :
                    graph[v]) {
                if (!visited[next]) {
                    color[next] = !color[v];
                    deque.add(next);
                    visited[next] = true;
                } else {
                    if (color[next] == color[v]) {
                        ok = false;
                        break;
                    }
                }
            }

        }
    }


    /*
    给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。

给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和 bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/possible-bipartition
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //BFS
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(dislikes, n);
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                traverse3(graph, i);
            }
        }
        return ok;
    }

    private void traverse3(List<Integer>[] graph, int start) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer t = queue.pollLast();
            for (int next :
                    graph[t]) {
                if (!visited[next]) {
                    color[next] = !color[t];
                    visited[next] = true;
                    queue.add(next);
                } else {
                    if (color[next] == color[t]) {
                        ok = false;
                        break;
                    }
                }
            }
        }
    }

    private List<Integer>[] buildGraph(int[][] dislikes, int n) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge :
                dislikes) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }

    //DFS
    public boolean possibleBipartition2(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(dislikes, n);
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                traverse4(graph, i);
            }
        }
        return ok;
    }

    private void traverse4(List<Integer>[] graph, int v) {
        if (!ok) {
            return;
        }
        visited[v] = true;
        for (int next :
                graph[v]) {
            if (!visited[next]) {
                color[next] = !color[v];
                visited[next] = true;
                traverse4(graph, next);
            } else {
                if (color[next] == color[v]) {
                    ok = false;
                }
            }
        }

    }

}
