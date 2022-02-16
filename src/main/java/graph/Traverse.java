package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Traverse {
    //所有可能路径
    /*
    给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
graph[i]是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点graph[i][j]存在一条有向边）。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
     */

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Deque<Integer> path = new LinkedList<>();
        traverse(0, path, graph);
        return res;
    }

    private void traverse(int s, Deque<Integer> path, int[][] graph) {
        path.add(s);
        int n = graph.length;
        if (s == n - 1) {
            res.add(new LinkedList<Integer>(path));
            path.removeLast();
            return;
        }

        for (int v :
                graph[s]) {
            traverse(v, path, graph);
        }
        path.removeLast();
    }
}
