package graph.mst;

import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    boolean[] visited;
    //[from,to,weight],邻接表
    List<int[]>[] graph;
    //总权重
    int weightSum = 0;
    PriorityQueue<int[]> pq;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        int n = graph.length;
        visited = new boolean[n];
        pq = new PriorityQueue<>((a, b) ->
                //按照权重由小到大
                (a[2] - b[2]));
        //从0开始割
        visited[0] = true;
        cut(0);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (visited[to]) {
                continue;
            }
            weightSum += weight;
            visited[to] = true;
            cut(to);
        }
    }

    private void cut(int s) {
        for (int[] edge :
                graph[s]) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (visited[to]) {
                continue;
            }
            visited[to] = true;
            pq.add(edge);
        }
    }

    public int getWeightSum() {
        return weightSum;
    }

    public boolean isAllConnect() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
