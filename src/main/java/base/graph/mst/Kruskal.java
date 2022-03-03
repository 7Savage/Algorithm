package base.graph.mst;

import base.graph.UnionFind;

import java.util.Arrays;


public class Kruskal {
    int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n+1);
        int res = 0;
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (uf.connected(from, to)) {
                continue;
            }
            res += weight;
            uf.union(from, to);
        }
        //默认0不使用，所以会多一个
        return uf.count() == 2 ? res : -1;
    }
}
