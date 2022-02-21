package graph;

public class UnionFind {

    int count;//连通分量
    int[] parent; //父亲节点
    int[] size; //重量

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //连接
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[pRoot] += qRoot;
        }
        count--;
    }

    //找寻根节点
    private int find(int x) {
        while (parent[x] != x) {
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //返回连通量
    public int count() {
        return count;
    }

    // 判断输入的若干条边是否能构造出一棵树结构
    boolean validTree(int n, int[][] edges) {
        // 初始化 0...n-1 共 n 个节点
        UnionFind uf = new UnionFind(n);
        // 遍历所有边，将组成边的两个节点进行连接
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // 若两个节点已经在同一连通分量中，会产生环
            if (uf.connected(u, v)) {
                return false;
            }
            // 这条边不会产生环，可以是树的一部分
            uf.union(u, v);
        }
        // 要保证最后只形成了一棵树，即只有一个连通分量
        return uf.count() == 1;
    }
}
