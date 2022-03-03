package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();//邻接表
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];//入度

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
            adjacency.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            List<Integer> list = adjacency.get(pre);
            for (Integer integer :
                    list) {
                if (--indegrees[integer] == 0) queue.add(integer);
            }
        }
        return numCourses == 0;
    }
}
