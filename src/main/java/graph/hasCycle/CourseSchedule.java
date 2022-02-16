package graph.hasCycle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
表示如果要学习课程ai 则 必须 先学习课程 bi 。

例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */


//标准的后序遍历结果不满足拓扑排序，而如果把后序遍历结果反转，就是拓扑排序结果了
public class CourseSchedule {

    boolean hasCycle;
    boolean[] onPath;
    boolean[] visited;

    //环检测算法，DFS版
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < graph.length; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (int t :
                graph[s]) {
            traverse(graph, t);
        }
        onPath[s] = false;
    }

    //环检测算法，BFS版
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] inDegree = new int[numCourses];
        for (int[] edge :
                prerequisites) {
            int from = edge[1];
            int to = edge[0];
            inDegree[to] += 1;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer t = queue.pollLast();
            count++;
            for (int next :
                    graph[t]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge :
                prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }


}
