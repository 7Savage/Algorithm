package graph;

public class Bipartite {

    boolean[] visited;
    boolean[] color;
    boolean ok = true;

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
                if (color[next] != color[v]) {
                    ok = false;
                }
            }
        }
    }
}
